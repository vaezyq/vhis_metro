package com.missiongroup.starring.modular.vhis.monitoring.controller;

import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.modular.vhis.metro.domain.Line;
import com.missiongroup.starring.modular.vhis.monitoring.Clickhouse;
import com.missiongroup.starring.modular.vhis.monitoring.dto.trainInfo;
import com.missiongroup.starring.modular.vhis.monitoring.service.LineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fengli
 * @ClassName: LineInfoController
 * @Description: 线路信息
 * @date 2022年2月4日 下午3:13:41
 * city	project	lineNum	insert_time	collect_time	base	opening_time	power	station_num	total_length	transfer_num
 * 城市	项目	线路号	数据入库时间	配置数据字段时间	基地	开通时间	供电方式	车站数	线路总长度	可换乘线路数
 * trainNum	lineNum	network	signal_strength	model	current_station	next_station	status	is_online	is_operation	insert_time	collect_time
 * 车辆编号	线路号	车地网络	信号强度	运行模式	当前站	下一站	列车状态	是否在线	是否投运	数据入库时间	配置数据字段时间
 */
@SuppressWarnings("all")
@Api(value = "车厢管理接口管理")
@Controller
@RequestMapping("/lineInfoCtl")
public class LineInfoControllerNow extends BaseController {


    @Autowired
    LineService lineService;


    //1 查询某条线路信息   finished
    @ApiOperation(value = "查询线路信息", notes = "根据线路lineNum获取线路信息")
    @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String")
    @GetMapping(value = "/line")
    @ResponseBody
    public Object getLineInfoById(@RequestParam("lineNum") String lineNum) {
//        查询线路信息
        try {
            return LineService.getLineInfoById(lineNum);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //2 所有线路信息   finished
    @ApiOperation(value = "查询线路信息", notes = "获取所有线路信息")
//    @GetMapping(value = "/line/{getAll}")
    @GetMapping(value = "/line/getAll")
    @ResponseBody
    public Object getLineInfos() {
        try {
            return LineService.getLineInfos();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    //3查询当前线路所有车辆信息   finished
    @ApiOperation(value = "查询车辆信息", notes = "获取当前线路所有最新的车辆信息")
    //    @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String")
    @GetMapping(value = "/trainInfos")
    @ResponseBody
    public Object getTianInfos(@RequestParam("lineNum") String lineNum) {
        try {
            return lineService.getAllTianInfoByLineNum(lineNum);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    //4查询当前线路下一条车辆信息   finished
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
            return lineService.getTianInfoByTrainNum(lineNum, trainNum);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    //5查询所有投运状态的列车 is_online   finished
    @ApiOperation(value = "查询当前线路投运列车", notes = "查询当前线路所有投运状态的列车")
    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
    })
    @GetMapping(value = "/trainInfo/operation")
    @ResponseBody
    public Object getTianInfoOperation(@RequestParam("lineNum") String lineNum) {
        try {
            Map<Integer, trainInfo> operationLineNumTrainInfo = new HashMap<>();
            Map<Integer, trainInfo> allLineNumTrainInfo = lineService.getAllTianInfoByLineNum(lineNum);

            for (Map.Entry<Integer, trainInfo> entry : allLineNumTrainInfo.entrySet()) {

                //这个投运字段的结果还没有给定,目前全部为投运
                if (entry.getValue().getIs_operation().equals("yes")) {
                    operationLineNumTrainInfo.put(entry.getKey(), entry.getValue());
                }
            }
            return operationLineNumTrainInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    //6查询所有在线状态的列车   finished
    @ApiOperation(value = "查询在线状态的列车", notes = "查询所有在线状态的列车")
    //@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
    })
    @GetMapping(value = "/trainInfo/online")
    @ResponseBody
    public Object getTianInfoOnline(@RequestParam("lineNum") String lineNum) {
        try {
            Map<Integer, trainInfo> onlineLineNumTrainInfo = new HashMap<>();
            Map<Integer, trainInfo> allLineNumTrainInfo = lineService.getAllTianInfoByLineNum(lineNum);
            for (Map.Entry<Integer, trainInfo> entry : allLineNumTrainInfo.entrySet()) {
                if (entry.getValue().getIs_online().equals("online")) {
                    onlineLineNumTrainInfo.put(entry.getKey(), entry.getValue());
                }
            }
            return onlineLineNumTrainInfo;
        } catch (Exception e) {
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
            Map<Integer, trainInfo> offlineLineNumTrainInfo = new HashMap<>();
            Map<Integer, trainInfo> allLineNumTrainInfo = lineService.getAllTianInfoByLineNum(lineNum);
            for (Map.Entry<Integer, trainInfo> entry : allLineNumTrainInfo.entrySet()) {
                if (entry.getValue().getIs_online().equals("offline")) {
                    offlineLineNumTrainInfo.put(entry.getKey(), entry.getValue());
                }
            }
            return offlineLineNumTrainInfo;
        } catch (Exception e) {
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
            Map<Integer, trainInfo> offlineLineNumTrainInfo = new HashMap<>();
            Map<Integer, trainInfo> allLineNumTrainInfo = lineService.getAllTianInfoByLineNum(lineNum);
            for (Map.Entry<Integer, trainInfo> entry : allLineNumTrainInfo.entrySet()) {
                if (entry.getValue().getStatus().equals("fault")) {
                    offlineLineNumTrainInfo.put(entry.getKey(), entry.getValue());
                }
            }
            return offlineLineNumTrainInfo;
        } catch (Exception e) {
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
            Map<Integer, trainInfo> offlineLineNumTrainInfo = new HashMap<>();
            Map<Integer, trainInfo> allLineNumTrainInfo = lineService.getAllTianInfoByLineNum(lineNum);
            for (Map.Entry<Integer, trainInfo> entry : allLineNumTrainInfo.entrySet()) {
                if (entry.getValue().getStatus().equals("warning")) {
                    offlineLineNumTrainInfo.put(entry.getKey(), entry.getValue());
                }
            }
            return offlineLineNumTrainInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
