package com.missiongroup.starring.modular.vhis.video.controller;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.Const;
import com.missiongroup.starring.common.constant.dictmap.UserDict;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.modular.system.domain.User;
import com.missiongroup.starring.modular.vhis.monitoring.Clickhouse;
import com.missiongroup.starring.modular.vhis.video.video_config;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @ClassName: video_train
 * @Description: 监控信息
 * @author fengli
 * @date 2022年2月4日 下午3:13:41
 *id	project	   line       train	      box
 *编号	项目	   线路号	  列车号     车厢号
 *
 *  * @ClassName: video_config
 *  * @Description: 监控信息
 *  * @author fengli
 *  * @date 2022年2月4日 下午3:13:41
 *  *id	    location	   camera    stream
 *  *编号	位置信息	       摄像头编号	  流地址
 */
@SuppressWarnings("all")
@Api(value = "车厢管理接口管理")
@Controller
@RequestMapping("/VideoInfoCtl")
public class VideoController  extends BaseController{

    //1查询项目信息
    @ApiOperation(value = "查询项目信息", notes = "查询所有的project")
    @GetMapping(value = "/project")
    @ResponseBody
    public Object getProjectInfoById() {
        try {
            String sql = "select distinct project from video_train";
            List<Map<String, String>> result = video_config.exeSql(sql);
//            Clickhouse object = new Clickhouse();
//            object.handle02();
            if(result!=null){
                return  result;
            }else{
                return  "";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    //2查询线路信息
    @ApiOperation(value = "查询线路信息", notes = "查询当前project下所有的线路信息")
    @ApiImplicitParam(name = "projectNum", value = "projectNum", required = true, dataType = "String")
    @GetMapping(value = "/line")
    @ResponseBody
    public Object getLineInfoByProject(@RequestParam("projectNum") String projectNum) {
        try {
            String sql = "select distinct line from video_train where project='"+projectNum+"' order by line asc";
//            String sql = "select distinct line from video_train where project='"+projectNum+"'";
            List<Map<String, String>> result = video_config.exeSql(sql);
//            Clickhouse object = new Clickhouse();
//            object.handle02();
            if (result != null) {
                return result;
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //3查询当前线路下一车辆信息
    @ApiOperation(value = "查询车辆信息", notes = "查询车辆信息")
    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "projectNum", value = "projectNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String")
    })
    @GetMapping(value = "/train")
    @ResponseBody
    public Object getTianInfoByLine(@RequestParam("projectNum") String projectNum, @RequestParam("lineNum") String lineNum) {
        try {
            String sql = "select distinct train from video_train where project='"+projectNum+"' and line='"+lineNum+"' order by train asc";
//            String sql = "select distinct line from video_train where project='"+projectNum+"'";
            List<Map<String, String>> result = video_config.exeSql(sql);
//            object.handle02();
            if(result!=null){
                return  result;
            }else{
                return  "";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    //4查询当前车辆下的车厢信息
    @ApiOperation(value = "查询车厢信息", notes = "查询车厢信息")
    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "projectNum", value = "projectNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    })
    @GetMapping(value = "/box")
    @ResponseBody
    public Object getBoxInfoByLine(@RequestParam("projectNum") String projectNum, @RequestParam("lineNum") String lineNum, @RequestParam("trainNum") String trainNum) {
        try {
            String sql = "select distinct box from video_train where project='"+projectNum+"' and line='"+lineNum+"' and train='"+trainNum+"'order by box asc";
//            String sql = "select distinct line from video_train where project='"+projectNum+"'";
            List<Map<String, String>> result = video_config.exeSql(sql);
//            object.handle02();
            if(result!=null){
                return  result;
            }else{
                return  "";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    //5添加摄像头信息
    @ApiOperation(value = "添加摄像头", notes = "添加摄像头信息")
    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "projectNum", value = "projectNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "box", value = "box", required = true, dataType = "String"),
            @ApiImplicitParam(name = "location", value = "lineNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "stream", value = "trainNum", required = true, dataType = "String")
    })
    @GetMapping(value = "/addVideo")
    @ResponseBody
    public void addVideoInfoByBox(@RequestParam("projectNum") String projectNum, @RequestParam("lineNum") String lineNum, @RequestParam("trainNum") String trainNum, @RequestParam("box") String box, @RequestParam("location") String location, @RequestParam("stream") String stream) {
        try {
            String sql = "insert into video_config(hash, location, stream) values('"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"','"+location+"','"+stream+"')";
//            String sql = "select distinct box from video_train where project='"+projectNum+"' and line='"+lineNum+"' and train='"+trainNum+"'order by box asc";
//            String sql = "select distinct line from video_train where project='"+projectNum+"'";
//            List<Map<String, String>> result = video_config.exeSql(sql);
            video_config.insertSql(sql);
//            object.handle02();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //6删除摄像头信息
    @ApiOperation(value = "删除摄像头", notes = "删除摄像头信息")
    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "projectNum", value = "projectNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "box", value = "box", required = true, dataType = "String"),
            @ApiImplicitParam(name = "location", value = "lineNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "stream", value = "trainNum", required = true, dataType = "String")
    })
    @GetMapping(value = "/deleteVideo")
    @ResponseBody
    public void deleteVideoInfoByBox(@RequestParam("projectNum") String projectNum, @RequestParam("lineNum") String lineNum, @RequestParam("trainNum") String trainNum, @RequestParam("box") String box, @RequestParam("location") String location, @RequestParam("stream") String stream) {
        try {
//            String sql = "insert into video_config(hash, location, stream) values('"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"','"+location+"','"+stream+"')";
            String sql = "delete from video_config where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"' and stream='"+stream+"'";
//            String sql = "select distinct box from video_train where project='"+projectNum+"' and line='"+lineNum+"' and train='"+trainNum+"'order by box asc";
//            String sql = "select distinct line from video_train where project='"+projectNum+"'";
//            List<Map<String, String>> result = video_config.exeSql(sql);
            video_config.insertSql(sql);
//            object.handle02();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //7编辑摄像头信息
    @ApiOperation(value = "删除摄像头", notes = "删除摄像头信息")
    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectNum", value = "projectNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "box", value = "box", required = true, dataType = "String"),
            @ApiImplicitParam(name = "location", value = "lineNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "stream", value = "trainNum", required = true, dataType = "String")
    })
    @GetMapping(value = "/updateVideo")
    @ResponseBody
    public void updateVideoInfoByBox(@RequestParam("projectNum") String projectNum, @RequestParam("lineNum") String lineNum, @RequestParam("trainNum") String trainNum, @RequestParam("box") String box, @RequestParam("location") String location, @RequestParam("stream") String stream) {
        try {
//            String sql = "insert into video_config(hash, location, stream) values('"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"','"+location+"','"+stream+"')";
//            String sql = "delete from video_config where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"' and location='"+location+"' and stream='"+stream+"'";
//            String sql = "update video_config set location='"+location+"',stream='"+stream+"' where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"' and location='"+location+"' and stream='"+stream+"'";
//            String sql = "select distinct box from video_train where project='"+projectNum+"' and line='"+lineNum+"' and train='"+trainNum+"'order by box asc";
//            String sql = "select distinct line from video_train where project='"+projectNum+"'";
            String sql = "update video_config set stream='"+stream+"' where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"' and location='"+location+"'";
//            List<Map<String, String>> result = video_config.exeSql(sql);
            video_config.exeSql(sql);
//            object.handle02();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //8查询摄像头信息
    @ApiOperation(value = "查询摄像头信息", notes = "查询摄像头信息")
    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "projectNum", value = "projectNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "box", value = "box", required = true, dataType = "String"),
            @ApiImplicitParam(name = "location", value = "lineNum", required = true, dataType = "String"),
    })
    @GetMapping(value = "/InquireVideo")
    @ResponseBody
    public Object InquireVideoInfoByLine(@RequestParam("projectNum") String projectNum, @RequestParam("lineNum") String lineNum, @RequestParam("trainNum") String trainNum, @RequestParam("box") String box, @RequestParam("location") String location) {
        try {
//            List<Map<String, String>> result = new List<Map<String, String>>;
            if (location == "") {
                String sql = "select location,stream from video_config where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"'";
//            String sql = "select distinct line from video_train where project='"+projectNum+"'";
                List<Map<String, String>> result = video_config.exeSql(sql);
                return result;
            }else{
                String sql = "select stream from video_config where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"' and location='"+location+"'";
//            String sql = "select distinct line from video_train where project='"+projectNum+"'";
                List<Map<String, String>> result = video_config.exeSql(sql);
                return result;
            }
//            String sql = "select stream from video_config where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"' and location='"+location+"'";
////            String sql = "select distinct line from video_train where project='"+projectNum+"'";
//            List<Map<String, String>> result = video_config.exeSql(sql);
//            object.handle02();

        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }



}
