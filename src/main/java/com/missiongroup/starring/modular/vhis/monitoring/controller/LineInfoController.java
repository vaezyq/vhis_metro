//package com.missiongroup.starring.modular.vhis.monitoring.controller;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import javax.validation.Valid;
//
//import com.missiongroup.starring.modular.vhis.monitoring.Clickhouse;
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import com.missiongroup.starring.common.annotion.BussinessLog;
//import com.missiongroup.starring.common.constant.dictmap.vhis.metro.CarriageDict;
//import com.missiongroup.starring.common.domain.PageDirection;
//import com.missiongroup.starring.common.domain.PageParam;
//import com.missiongroup.starring.common.domain.PageResult;
//import com.missiongroup.starring.common.exception.BizExceptionEnum;
//import com.missiongroup.starring.common.exception.BussinessException;
//import com.missiongroup.starring.core.base.controller.BaseController;
//import com.missiongroup.starring.core.log.LogObjectHolder;
//import com.missiongroup.starring.core.shiro.ShiroKit;
//import com.missiongroup.starring.core.util.ToolUtil;
//import com.missiongroup.starring.modular.vhis.metro.domain.Carriage;
//import com.missiongroup.starring.modular.vhis.metro.domain.dto.CarriageDto;
//import com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper.CarriageWarpper;
//import com.missiongroup.starring.modular.vhis.metro.service.CarriageService;
//
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//
///**
// *
// * @ClassName: LineInfoController
// * @Description: ????????????
// * @author fengli
// * @date 2022???2???4??? ??????3:13:41
// *city	project	lineNum	insert_time	collect_time	base	opening_time	power	station_num	total_length	transfer_num
// * ??????	??????	?????????	??????????????????	????????????????????????	??????	????????????	????????????	?????????	???????????????	??????????????????
// *trainNum	lineNum	network	signal_strength	model	current_station	next_station	status	is_online	is_operation	insert_time	collect_time
// * ????????????	?????????	????????????	????????????	????????????	?????????	?????????	????????????	????????????	????????????	??????????????????	????????????????????????
// */
//@SuppressWarnings("all")
//
//
//@Api(value = "????????????????????????")
//@Controller
//@RequestMapping("/lineInfoCtl")
//public class LineInfoController  extends BaseController {
//
//
//    //1????????????????????????
//    @ApiOperation(value = "??????????????????", notes = "????????????lineNum??????????????????")
//    @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String")
//    @GetMapping(value = "/line")
//    @ResponseBody
//    public Object getLineInfoById(@RequestParam("lineNum") String lineNum) {
//        try {
//            String sql = "select * from line_content where lineNum='"+lineNum+"'";
////            String sql = "select top 1 * from traincard where lineNum='"+lineNum+"'";
//            List<Map<String,String>> result = Clickhouse.exeSql(sql);
////            Clickhouse object = new Clickhouse();
////            object.handle02();
//            if(result!=null){
//                return  result.get(0);
//            }else{
//                return  "";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//
//
//    //2??????????????????
//    @ApiOperation(value = "??????????????????", notes = "????????????????????????")
////    @GetMapping(value = "/line/{getAll}")
//    @GetMapping(value = "/line/getAll")
//    @ResponseBody
//    public Object getLineInfos() {
//        try {
////            String sql = "select * from line_content";
//            String sql = "select * from line_content";
//            List<Map<String,String>> result = Clickhouse.exeSql(sql);
////            Clickhouse object = new Clickhouse();
////            object.handle02();
//            if(result!=null){
//                return  result;
//            }else{
//                return  "";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//    //3????????????????????????????????????
//    @ApiOperation(value = "??????????????????", notes = "?????????????????????????????????????????????")
//    //    @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String")
//    @GetMapping(value = "/trainInfos")
//    @ResponseBody
//    public Object getTianInfos(@RequestParam("lineNum") String lineNum) {
//        try {
////            String sql = "select * from train12_content where lineNum='"+lineNum+"'";
////            String sql = "select top 13 * from train"+lineNum+"_content order by insert_time desc, lineNum";
//            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
//            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
////            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc,trainNum asc";
////            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content";
////            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) order by trainNum asc";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) order by trainNum asc";
////            String sql = "select * from train"+lineNum+"_content";
//            List<Map<String,String>> result = Clickhouse.exeSql(sql);
////            Clickhouse object = new Clickhouse();
////            object.handle02();
//            if(result!=null){
//                return  result;
//            }else{
//                return  "";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//
//    }
//
//
//    //4???????????????????????????????????????
//    @ApiOperation(value = "??????????????????", notes = "????????????????????????")
//    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
//    @ApiImplicitParams({ //
//            @ApiImplicitParam(name = "lineNum", value = "??????ID???lineNum", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "trainNum", value = "??????ID???trainNum", required = true, dataType = "String")
//    })
//    @GetMapping(value = "/trainInfo")
//    @ResponseBody
//    public Object getTianInfoByTrainNum(@RequestParam("lineNum") String lineNum, @RequestParam("trainNum") String trainNum) {
//        try {
//            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
//            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
//            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where trainNum='"+trainNum+"'";
//            List<Map<String,String>> result = Clickhouse.exeSql(sql);
////            Clickhouse object = new Clickhouse();
////            object.handle02();
//            if(result!=null){
//                return  result.get(0);
//            }else{
//                return  "";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//
////    @ApiOperation(value = "??????????????????", notes = "????????????????????????")
////    //  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
////    @ApiImplicitParams({ //
////            @ApiImplicitParam(name = "lineNum", value = "??????ID???lineNum", required = true, dataType = "String"),
////            @ApiImplicitParam(name = "trainNum", value = "??????ID???trainNum", required = true, dataType = "String")
////    })
////    @GetMapping(value = "/trainInfo")
////    @ResponseBody
////    public Object getTianInfoByTrainNum(@RequestParam("lineNum") String lineNum, @RequestParam("trainNum") String trainNum) {
////
////    }
//
//    //5????????????????????????????????? is_online
//    @ApiOperation(value = "??????????????????????????????", notes = "?????????????????????????????????????????????")
//    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
//    @ApiImplicitParams({ //
//            @ApiImplicitParam(name = "lineNum", value = "??????ID???lineNum", required = true, dataType = "String"),
//    })
//    @GetMapping(value = "/trainInfo/operation")
//    @ResponseBody
//    public Object getTianInfoOperation(@RequestParam("lineNum") String lineNum) {
//        try {
//            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
//            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
////            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) order by trainNum asc";
////            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where is_operation='yes'";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where is_operation='yes' order by trainNum asc";
//            List<Map<String,String>> result = Clickhouse.exeSql(sql);
////            Clickhouse object = new Clickhouse();
////            object.handle02();
//            if(result!=null){
//                return  result;
//            }else{
//                return  "";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//
//    }
//
//    //6?????????????????????????????????
//    @ApiOperation(value = "???????????????????????????", notes = "?????????????????????????????????")
//    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
//    @ApiImplicitParams({ //
//            @ApiImplicitParam(name = "lineNum", value = "??????ID???lineNum", required = true, dataType = "String"),
//    })
//    @GetMapping(value = "/trainInfo/online")
//    @ResponseBody
//    public Object getTianInfoOnline(@RequestParam("lineNum") String lineNum) {
//        try {
//            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
//            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
//
//            //String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where is_online='online'";
////            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where is_online='online'";
////            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) order by trainNum asc";
////            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) where is_online='online'";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where is_online='online' order by trainNum asc";
//            List<Map<String,String>> result = Clickhouse.exeSql(sql);
////            Clickhouse object = new Clickhouse();
////            object.handle02();
////            System.out.println(result);
//            if(result!=null){
//                return  result;
//            }else{
//                return  "";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//
//
//    //7?????????????????????????????????
//    @ApiOperation(value = "???????????????????????????", notes = "?????????????????????????????????")
//    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
//    @ApiImplicitParams({ //
//            @ApiImplicitParam(name = "lineNum", value = "??????ID???lineNum", required = true, dataType = "String"),
//    })
//    @GetMapping(value = "/trainInfo/outline")
//    @ResponseBody
//    public Object getTianInfoOutline(@RequestParam("lineNum") String lineNum) {
//        try {
//            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
//            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
////            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where is_online='offline'";
////            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) where is_online='offline'";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where is_online='offline' order by trainNum asc";
//            List<Map<String,String>> result = Clickhouse.exeSql(sql);
////            Clickhouse object = new Clickhouse();
////            object.handle02();
////            System.out.println(result);
//            if(result!=null){
//                return  result;
//            }else{
//                return  "";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//
//    }
//
//    //01 ?????? fault ?????? warning ??????
//    //8?????????????????????????????????
//    @ApiOperation(value = "???????????????????????????", notes = "?????????????????????????????????")
//    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
//    @ApiImplicitParams({ //
//            @ApiImplicitParam(name = "lineNum", value = "??????ID???lineNum", required = true, dataType = "String"),
//    })
//    @GetMapping(value = "/trainInfo/status02")
//    @ResponseBody
//    public Object getTianInfoStatus02(@RequestParam("lineNum") String lineNum) {
//        try {
//            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
//            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
////            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where status='fault'";
////            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) where status='fault'";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where status='fault' order by trainNum asc";
//            List<Map<String,String>> result = Clickhouse.exeSql(sql);
////            Clickhouse object = new Clickhouse();
////            object.handle02();
//            if(result!=null){
//                return  result;
//            }else{
//                return  "";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//
//    }
//
//
//    //9?????????????????????????????????
//    @ApiOperation(value = "???????????????????????????", notes = "?????????????????????????????????")
//    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
//    @ApiImplicitParams({ //
//            @ApiImplicitParam(name = "lineNum", value = "??????ID???lineNum", required = true, dataType = "String"),
//    })
//    @GetMapping(value = "/trainInfo/status03")
//    @ResponseBody
//    public Object getTianInfoStatus03(@RequestParam("lineNum") String lineNum) {
//        try {
//            String temp = "select train_num from line_content where lineNum='"+lineNum+"'";
//            List<Map<String,String>> result1 = Clickhouse.exeSql(temp);
////            String sql = "select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content where status='warning'";
////            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content) where status='warning'";
//            String sql = "select * from (select top "+result1.get(0).get("train_num")+" * from train"+lineNum+"_content order by insert_time desc) where status='warning' order by trainNum asc";
//            List<Map<String,String>> result = Clickhouse.exeSql(sql);
////            Clickhouse object = new Clickhouse();
////            object.handle02();
//            if(result!=null){
//                return  result;
//            }else{
//                return  "";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//
//    }
//
//
//}
