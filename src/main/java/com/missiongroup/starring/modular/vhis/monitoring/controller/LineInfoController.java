package com.missiongroup.starring.modular.vhis.monitoring.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.missiongroup.starring.modular.vhis.monitoring.Clickhouse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.vhis.metro.CarriageDict;
import com.missiongroup.starring.common.domain.PageDirection;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.vhis.metro.domain.Carriage;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.CarriageDto;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper.CarriageWarpper;
import com.missiongroup.starring.modular.vhis.metro.service.CarriageService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @ClassName: LineInfoController
 * @Description: 线路信息
 * @author fengli
 * @date 2022年2月4日 下午3:13:41
 *city	project	lineNum	insert_time	collect_time	base	opening_time	power	station_num	total_length	transfer_num
 * 城市	项目	线路号	数据入库时间	配置数据字段时间	基地	开通时间	供电方式	车站数	线路总长度	可换乘线路数
 *trainNum	lineNum	network	signal_strength	model	current_station	next_station	status	is_online	is_operation	insert_time	collect_time
 * 车辆编号	线路号	车地网络	信号强度	运行模式	当前站	下一站	列车状态	是否在线	是否投运	数据入库时间	配置数据字段时间
 */
@SuppressWarnings("all")
@Api(value = "车厢管理接口管理")
@Controller
@RequestMapping("/lineInfoCtl")
public class LineInfoController  extends BaseController {


    //1查询某条线路信息
    @ApiOperation(value = "查询线路信息", notes = "根据线路lineNum获取线路信息")
    @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String")
    @GetMapping(value = "/line")
    @ResponseBody
    public Object getLineInfoById(@RequestParam("lineNum") String lineNum) {
        try {
            String sql = "select * from line_content where lineNum='"+lineNum+"'";
            List<Map<String,String>> result = Clickhouse.exeSql(sql);
//            Clickhouse object = new Clickhouse();
//            object.handle02();
            if(result!=null){
                return  result.get(0);
            }else{
                return  "";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }



    }
    //2所有线路信息
    @ApiOperation(value = "查询线路信息", notes = "获取所有线路信息")
//    @GetMapping(value = "/line/{getAll}")
    @GetMapping(value = "/line/getAll")
    @ResponseBody
    public Object getLineInfos() {
        try {
            String sql = "select * from line_content";
            List<Map<String,String>> result = Clickhouse.exeSql(sql);
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

    //3查询当前线路所有车辆信息
    @ApiOperation(value = "查询车辆信息", notes = "获取当前线路所有最新的车辆信息")
    //    @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String")
    @GetMapping(value = "/trainInfos")
    @ResponseBody
    public Object getTianInfos(@RequestParam("lineNum") String lineNum) {
        try {
//            String sql = "select * from train12_content where lineNum='"+lineNum+"'";
//            String sql = "select top 13 * from train"+lineNum+"_content order by insert_time desc, lineNum";
            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
//            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc,trainNum asc";
//            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) order by trainNum asc";
            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) order by trainNum asc";
//            String sql = "select * from train"+lineNum+"_content";
            List<Map<String,String>> result = Clickhouse.exeSql(sql);
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


    //4查询当前线路下一条车辆信息
    @ApiOperation(value = "查询车辆信息", notes = "查询一条车辆信息")
    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
            @ApiImplicitParam(name = "trainNum", value = "列车ID：trainNum", required = true, dataType = "String")
    })
    @GetMapping(value = "/trainInfo")
    @ResponseBody
    public Object getTianInfoByTrainNum(@RequestParam("lineNum") String lineNum, @RequestParam("trainNum") String trainNum) {
        try {
            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where trainNum='"+trainNum+"'";
            List<Map<String,String>> result = Clickhouse.exeSql(sql);
//            Clickhouse object = new Clickhouse();
//            object.handle02();
            if(result!=null){
                return  result.get(0);
            }else{
                return  "";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }


//    @ApiOperation(value = "查询车辆信息", notes = "查询一条车辆信息")
//    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
//    @ApiImplicitParams({ //
//            @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "trainNum", value = "列车ID：trainNum", required = true, dataType = "String")
//    })
//    @GetMapping(value = "/trainInfo")
//    @ResponseBody
//    public Object getTianInfoByTrainNum(@RequestParam("lineNum") String lineNum, @RequestParam("trainNum") String trainNum) {
//
//    }

    //5查询所有投运状态的列车 is_online
    @ApiOperation(value = "查询当前线路投运列车", notes = "查询当前线路所有投运状态的列车")
    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
    })
    @GetMapping(value = "/trainInfo/operation")
    @ResponseBody
    public Object getTianInfoOperation(@RequestParam("lineNum") String lineNum) {
        try {
            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) order by trainNum asc";
//            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where is_operation='yes'";
            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where is_operation='yes' order by trainNum asc";
            List<Map<String,String>> result = Clickhouse.exeSql(sql);
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

    //6查询所有在线状态的列车
    @ApiOperation(value = "查询在线状态的列车", notes = "查询所有在线状态的列车")
    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
    })
    @GetMapping(value = "/trainInfo/online")
    @ResponseBody
    public Object getTianInfoOnline(@RequestParam("lineNum") String lineNum) {
        try {
            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);

            //String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where is_online='online'";
//            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where is_online='online'";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) order by trainNum asc";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) where is_online='online'";
            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where is_online='online' order by trainNum asc";
            List<Map<String,String>> result = Clickhouse.exeSql(sql);
//            Clickhouse object = new Clickhouse();
//            object.handle02();
//            System.out.println(result);
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

    //7查询所有离线状态的列车
    @ApiOperation(value = "查询离线状态的列车", notes = "查询所有离线状态的列车")
    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
    })
    @GetMapping(value = "/trainInfo/outline")
    @ResponseBody
    public Object getTianInfoOutline(@RequestParam("lineNum") String lineNum) {
        try {
            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
//            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where is_online='offline'";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) where is_online='offline'";
            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where is_online='offline' order by trainNum asc";
            List<Map<String,String>> result = Clickhouse.exeSql(sql);
//            Clickhouse object = new Clickhouse();
//            object.handle02();
//            System.out.println(result);
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

    //01 正常 fault 故障 warning 预警
    //8查询所有故障状态的列车
    @ApiOperation(value = "查询故障状态的列车", notes = "查询所有故障状态的列车")
    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
    })
    @GetMapping(value = "/trainInfo/status02")
    @ResponseBody
    public Object getTianInfoStatus02(@RequestParam("lineNum") String lineNum) {
        try {
            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
//            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where status='fault'";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) where status='fault'";
            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where status='fault' order by trainNum asc";
            List<Map<String,String>> result = Clickhouse.exeSql(sql);
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


    //9查询所有预警状态的列车
    @ApiOperation(value = "查询预警状态的列车", notes = "查询所有预警状态的列车")
    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
    })
    @GetMapping(value = "/trainInfo/status03")
    @ResponseBody
    public Object getTianInfoStatus03(@RequestParam("lineNum") String lineNum) {
        try {
            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
//            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where status='warning'";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) where status='warning'";
            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where status='warning' order by trainNum asc";
            List<Map<String,String>> result = Clickhouse.exeSql(sql);
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


}
