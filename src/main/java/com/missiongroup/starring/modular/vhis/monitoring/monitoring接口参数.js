//1.查询某条线路信息
@ApiOperation(value = "查询线路信息", notes = "根据线路lineNum获取线路信息")
@ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String")
@GetMapping(value = "/line/{lineNum}")
getLineInfoById
localhost:9082/lineInfoCtl/line/12
{
    "total_line_length": "215",
    "train_num": "13",
    "transfer_points_num": "13",
    "city": "南京",
    "opening_time": "2015.11.12",
    "project": "project_01",
    "insert_time": "2020.11.12",
    "line_config_num": "5",
    "station_num": "13",
    "lineNum": "12",
    "id": "0",
    "collect_time": "2018.11.12",
    "power": "power01",
    "transfer_line_num": "3",
    "base": "南大站"
}

//2.查询所有线路信息 /line/getAll
@ApiOperation(value = "查询线路信息", notes = "获取所有线路信息")
//    @GetMapping(value = "/line/{getAll}")
@GetMapping(value = "/line/getAll")
localhost:9082/lineInfoCtl//line/getAll
getLineInfos
    [
    {
        "total_line_length": "324",
        "train_num": "13",
        "transfer_points_num": "15",
        "city": "南京",
        "opening_time": "2014.12.13",
        "project": "project_01",
        "insert_time": "2021.12.13",
        "line_config_num": "6",
        "station_num": "15",
        "lineNum": "11",
        "id": "1",
        "collect_time": "2019.12.13",
        "power": "power02",
        "transfer_line_num": "4",
        "base": "东南大学站"
    },
        {
            "total_line_length": "215",
            "train_num": "13",
            "transfer_points_num": "13",
            "city": "南京",
            "opening_time": "2015.11.12",
            "project": "project_01",
            "insert_time": "2020.11.12",
            "line_config_num": "5",
            "station_num": "13",
            "lineNum": "12",
            "id": "0",
            "collect_time": "2018.11.12",
            "power": "power01",
            "transfer_line_num": "3",
            "base": "南大站"
        }
    ]

3.查询当前线路所有车辆信息  /trainInfos/{lineNum}
@ApiOperation(value = "查询车辆信息", notes = "获取当前线路所有最新的车辆信息")
//    @ApiImplicitParam(name = "lineNum", value = "lineNum", required = true, dataType = "String")
@GetMapping(value = "/trainInfos/{lineNum}")
getTianInfos
    [
    {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:001",
            "control_model": "control01",
            "network": "net01",
            "total_train_length": "55",
            "trainNum": "1201",
            "next_station": "东南大学",
            "run_model": "run01",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2021/3/12_09:51:001",
            "current_station": "南京大学",
            "status": "fault"
    },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:002",
                "control_model": "control02",
                "network": "net02",
                "total_train_length": "65",
                "trainNum": "1202",
                "next_station": "南京南",
                "run_model": "run02",
                "lineNum": "12",
                "signal_strength": "weak",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:002",
                "current_station": "东南大学",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:003",
                "control_model": "control03",
                "network": "net03",
                "total_train_length": "43",
                "trainNum": "1203",
                "next_station": "玄武湖",
                "run_model": "run03",
                "lineNum": "12",
                "signal_strength": "medium",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:003",
                "current_station": "南京南",
                "status": "warning"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:004",
                "control_model": "control04",
                "network": "net04",
                "total_train_length": "132",
                "trainNum": "1204",
                "next_station": "南京站",
                "run_model": "run04",
                "lineNum": "12",
                "signal_strength": "strong",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:004",
                "current_station": "玄武湖",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:005",
                "control_model": "control05",
                "network": "net05",
                "total_train_length": "54",
                "trainNum": "1205",
                "next_station": "秦皇庙",
                "run_model": "run05",
                "lineNum": "12",
                "signal_strength": "strong",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:005",
                "current_station": "南京站",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:006",
                "control_model": "control06",
                "network": "net06",
                "total_train_length": "76",
                "trainNum": "1206",
                "next_station": "鼓楼",
                "run_model": "run06",
                "lineNum": "12",
                "signal_strength": "strong",
                "is_online": "offline",
                "collect_time": "2021/3/14_09:51:006",
                "current_station": "玄武湖",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:007",
                "control_model": "control07",
                "network": "net07",
                "total_train_length": "62",
                "trainNum": "1207",
                "next_station": "鸡鸣寺",
                "run_model": "run07",
                "lineNum": "12",
                "signal_strength": "medium",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:007",
                "current_station": "鼓楼",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:008",
                "control_model": "control08",
                "network": "net08",
                "total_train_length": "93",
                "trainNum": "1208",
                "next_station": "珠江路",
                "run_model": "run08",
                "lineNum": "12",
                "signal_strength": "weak",
                "is_online": "offline",
                "collect_time": "2021/3/14_09:51:008",
                "current_station": "鸡鸣寺",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:009",
                "control_model": "control09",
                "network": "net09",
                "total_train_length": "43",
                "trainNum": "1209",
                "next_station": "新街口",
                "run_model": "run09",
                "lineNum": "12",
                "signal_strength": "zero",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:009",
                "current_station": "珠江路",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:010",
                "control_model": "control10",
                "network": "net10",
                "total_train_length": "62",
                "trainNum": "1210",
                "next_station": "张府园",
                "run_model": "run10",
                "lineNum": "12",
                "signal_strength": "medium",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:010",
                "current_station": "新街口",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:011",
                "control_model": "control11",
                "network": "net11",
                "total_train_length": "95",
                "trainNum": "1211",
                "next_station": "三山街",
                "run_model": "run11",
                "lineNum": "12",
                "signal_strength": "zero",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:011",
                "current_station": "张府园",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:012",
                "control_model": "control12",
                "network": "net12",
                "total_train_length": "108",
                "trainNum": "1212",
                "next_station": "中华门",
                "run_model": "run12",
                "lineNum": "12",
                "signal_strength": "weak",
                "is_online": "offline",
                "collect_time": "2021/3/14_09:51:012",
                "current_station": "三山街",
                "status": "fault"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:013",
                "control_model": "control13",
                "network": "net13",
                "total_train_length": "74",
                "trainNum": "1213",
                "next_station": "安德门",
                "run_model": "run13",
                "lineNum": "12",
                "signal_strength": "strong",
                "is_online": "offline",
                "collect_time": "2021/3/14_09:51:013",
                "current_station": "中华门",
                "status": "warning"
        }
    ]

4.查询一条车辆信息
@ApiOperation(value = "查询车辆信息", notes = "查询一条车辆信息")
//  @ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
@ApiImplicitParams({ //
        @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
        @ApiImplicitParam(name = "trainNum", value = "列车ID：trainNum", required = true, dataType = "String")
})
@GetMapping(value = "/trainInfo")
getTianInfoByTrainNum
{
        "is_operation": "yes",
    "insert_time": "2021/3/14_09:51:001",
    "control_model": "control01",
    "network": "net01",
    "total_train_length": "55",
    "trainNum": "1201",
    "next_station": "东南大学",
    "run_model": "run01",
    "lineNum": "12",
    "signal_strength": "zero",
    "is_online": "online",
    "collect_time": "2021/3/12_09:51:001",
    "current_station": "南京大学",
    "status": "fault"
}


//5.查询所有投运状态的列车 is_online    /trianInfo/operation
@ApiOperation(value = "查询当前线路投运列车", notes = "查询当前线路所有投运状态的列车")
//@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
@ApiImplicitParams({ //
        @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
})
@GetMapping(value = "/trainInfo/operation")
getTianInfoOperation
    [
    {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:001",
            "control_model": "control01",
            "network": "net01",
            "total_train_length": "55",
            "trainNum": "1201",
            "next_station": "东南大学",
            "run_model": "run01",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2021/3/12_09:51:001",
            "current_station": "南京大学",
            "status": "fault"
    },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:002",
                "control_model": "control02",
                "network": "net02",
                "total_train_length": "65",
                "trainNum": "1202",
                "next_station": "南京南",
                "run_model": "run02",
                "lineNum": "12",
                "signal_strength": "weak",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:002",
                "current_station": "东南大学",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:003",
                "control_model": "control03",
                "network": "net03",
                "total_train_length": "43",
                "trainNum": "1203",
                "next_station": "玄武湖",
                "run_model": "run03",
                "lineNum": "12",
                "signal_strength": "medium",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:003",
                "current_station": "南京南",
                "status": "warning"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:004",
                "control_model": "control04",
                "network": "net04",
                "total_train_length": "132",
                "trainNum": "1204",
                "next_station": "南京站",
                "run_model": "run04",
                "lineNum": "12",
                "signal_strength": "strong",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:004",
                "current_station": "玄武湖",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:005",
                "control_model": "control05",
                "network": "net05",
                "total_train_length": "54",
                "trainNum": "1205",
                "next_station": "秦皇庙",
                "run_model": "run05",
                "lineNum": "12",
                "signal_strength": "strong",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:005",
                "current_station": "南京站",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:006",
                "control_model": "control06",
                "network": "net06",
                "total_train_length": "76",
                "trainNum": "1206",
                "next_station": "鼓楼",
                "run_model": "run06",
                "lineNum": "12",
                "signal_strength": "strong",
                "is_online": "offline",
                "collect_time": "2021/3/14_09:51:006",
                "current_station": "玄武湖",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:007",
                "control_model": "control07",
                "network": "net07",
                "total_train_length": "62",
                "trainNum": "1207",
                "next_station": "鸡鸣寺",
                "run_model": "run07",
                "lineNum": "12",
                "signal_strength": "medium",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:007",
                "current_station": "鼓楼",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:008",
                "control_model": "control08",
                "network": "net08",
                "total_train_length": "93",
                "trainNum": "1208",
                "next_station": "珠江路",
                "run_model": "run08",
                "lineNum": "12",
                "signal_strength": "weak",
                "is_online": "offline",
                "collect_time": "2021/3/14_09:51:008",
                "current_station": "鸡鸣寺",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:009",
                "control_model": "control09",
                "network": "net09",
                "total_train_length": "43",
                "trainNum": "1209",
                "next_station": "新街口",
                "run_model": "run09",
                "lineNum": "12",
                "signal_strength": "zero",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:009",
                "current_station": "珠江路",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:010",
                "control_model": "control10",
                "network": "net10",
                "total_train_length": "62",
                "trainNum": "1210",
                "next_station": "张府园",
                "run_model": "run10",
                "lineNum": "12",
                "signal_strength": "medium",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:010",
                "current_station": "新街口",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:011",
                "control_model": "control11",
                "network": "net11",
                "total_train_length": "95",
                "trainNum": "1211",
                "next_station": "三山街",
                "run_model": "run11",
                "lineNum": "12",
                "signal_strength": "zero",
                "is_online": "online",
                "collect_time": "2021/3/14_09:51:011",
                "current_station": "张府园",
                "status": "normal"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:012",
                "control_model": "control12",
                "network": "net12",
                "total_train_length": "108",
                "trainNum": "1212",
                "next_station": "中华门",
                "run_model": "run12",
                "lineNum": "12",
                "signal_strength": "weak",
                "is_online": "offline",
                "collect_time": "2021/3/14_09:51:012",
                "current_station": "三山街",
                "status": "fault"
        },
        {
                "is_operation": "yes",
                "insert_time": "2021/3/14_09:51:013",
                "control_model": "control13",
                "network": "net13",
                "total_train_length": "74",
                "trainNum": "1213",
                "next_station": "安德门",
                "run_model": "run13",
                "lineNum": "12",
                "signal_strength": "strong",
                "is_online": "offline",
                "collect_time": "2021/3/14_09:51:013",
                "current_station": "中华门",
                "status": "warning"
        }
    ]

//6查询所有在线状态的列车
@ApiOperation(value = "查询在线状态的列车", notes = "查询所有在线状态的列车")
//@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
@ApiImplicitParams({ //
    @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
})
@GetMapping(value = "/trainInfo/online")
getTianInfoOnline
    [
    {
        "is_operation": "yes",
        "insert_time": "2022/05/14_08:30:01:316",
        "control_model": "control13",
        "network": "net13",
        "total_train_length": "136",
        "trainNum": "1213",
        "next_station": "安德门",
        "run_model": "run13",
        "lineNum": "12",
        "signal_strength": "zero",
        "is_online": "online",
        "collect_time": "2022/05/14_08:30:01:316",
        "current_station": "中华门",
        "status": "fault"
    },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:001",
            "control_model": "control01",
            "network": "net01",
            "total_train_length": "55",
            "trainNum": "1201",
            "next_station": "东南大学",
            "run_model": "run01",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2021/3/12_09:51:001",
            "current_station": "南京大学",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:002",
            "control_model": "control02",
            "network": "net02",
            "total_train_length": "65",
            "trainNum": "1202",
            "next_station": "南京南",
            "run_model": "run02",
            "lineNum": "12",
            "signal_strength": "weak",
            "is_online": "online",
            "collect_time": "2021/3/14_09:51:002",
            "current_station": "东南大学",
            "status": "normal"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:003",
            "control_model": "control03",
            "network": "net03",
            "total_train_length": "43",
            "trainNum": "1203",
            "next_station": "玄武湖",
            "run_model": "run03",
            "lineNum": "12",
            "signal_strength": "medium",
            "is_online": "online",
            "collect_time": "2021/3/14_09:51:003",
            "current_station": "南京南",
            "status": "warning"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:004",
            "control_model": "control04",
            "network": "net04",
            "total_train_length": "132",
            "trainNum": "1204",
            "next_station": "南京站",
            "run_model": "run04",
            "lineNum": "12",
            "signal_strength": "strong",
            "is_online": "online",
            "collect_time": "2021/3/14_09:51:004",
            "current_station": "玄武湖",
            "status": "normal"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:005",
            "control_model": "control05",
            "network": "net05",
            "total_train_length": "54",
            "trainNum": "1205",
            "next_station": "秦皇庙",
            "run_model": "run05",
            "lineNum": "12",
            "signal_strength": "strong",
            "is_online": "online",
            "collect_time": "2021/3/14_09:51:005",
            "current_station": "南京站",
            "status": "normal"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:007",
            "control_model": "control07",
            "network": "net07",
            "total_train_length": "62",
            "trainNum": "1207",
            "next_station": "鸡鸣寺",
            "run_model": "run07",
            "lineNum": "12",
            "signal_strength": "medium",
            "is_online": "online",
            "collect_time": "2021/3/14_09:51:007",
            "current_station": "鼓楼",
            "status": "normal"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:009",
            "control_model": "control09",
            "network": "net09",
            "total_train_length": "43",
            "trainNum": "1209",
            "next_station": "新街口",
            "run_model": "run09",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2021/3/14_09:51:009",
            "current_station": "珠江路",
            "status": "normal"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:010",
            "control_model": "control10",
            "network": "net10",
            "total_train_length": "62",
            "trainNum": "1210",
            "next_station": "张府园",
            "run_model": "run10",
            "lineNum": "12",
            "signal_strength": "medium",
            "is_online": "online",
            "collect_time": "2021/3/14_09:51:010",
            "current_station": "新街口",
            "status": "normal"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:011",
            "control_model": "control11",
            "network": "net11",
            "total_train_length": "95",
            "trainNum": "1211",
            "next_station": "三山街",
            "run_model": "run11",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2021/3/14_09:51:011",
            "current_station": "张府园",
            "status": "normal"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:40:41:773",
            "control_model": "control01",
            "network": "net01",
            "total_train_length": "55",
            "trainNum": "1201",
            "next_station": "东南大学",
            "run_model": "run01",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:40:41:773",
            "current_station": "南京大学",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control01",
            "network": "net01",
            "total_train_length": "55",
            "trainNum": "1201",
            "next_station": "东南大学",
            "run_model": "run01",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "南京大学",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control02",
            "network": "net02",
            "total_train_length": "63",
            "trainNum": "1202",
            "next_station": "南京南",
            "run_model": "run02",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "东南大学",
            "status": "fault"
        }
    ]

//7查询所有离线状态的列车
@ApiOperation(value = "查询离线状态的列车", notes = "查询所有离线状态的列车")
//@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
@ApiImplicitParams({ //
    @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
})
@GetMapping(value = "/trainInfo/outline")
getTianInfoOutline
    [
    {
        "is_operation": "yes",
        "insert_time": "2021/3/14_09:51:006",
        "control_model": "control06",
        "network": "net06",
        "total_train_length": "76",
        "trainNum": "1206",
        "next_station": "鼓楼",
        "run_model": "run06",
        "lineNum": "12",
        "signal_strength": "strong",
        "is_online": "offline",
        "collect_time": "2021/3/14_09:51:006",
        "current_station": "玄武湖",
        "status": "normal"
    },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:008",
            "control_model": "control08",
            "network": "net08",
            "total_train_length": "93",
            "trainNum": "1208",
            "next_station": "珠江路",
            "run_model": "run08",
            "lineNum": "12",
            "signal_strength": "weak",
            "is_online": "offline",
            "collect_time": "2021/3/14_09:51:008",
            "current_station": "鸡鸣寺",
            "status": "normal"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:012",
            "control_model": "control12",
            "network": "net12",
            "total_train_length": "108",
            "trainNum": "1212",
            "next_station": "中华门",
            "run_model": "run12",
            "lineNum": "12",
            "signal_strength": "weak",
            "is_online": "offline",
            "collect_time": "2021/3/14_09:51:012",
            "current_station": "三山街",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:013",
            "control_model": "control13",
            "network": "net13",
            "total_train_length": "74",
            "trainNum": "1213",
            "next_station": "安德门",
            "run_model": "run13",
            "lineNum": "12",
            "signal_strength": "strong",
            "is_online": "offline",
            "collect_time": "2021/3/14_09:51:013",
            "current_station": "中华门",
            "status": "warning"
        }
    ]

//01 正常 fault 故障 warning 预警
//8查询所有故障状态的列车
@ApiOperation(value = "查询故障状态的列车", notes = "查询所有故障状态的列车")
//@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
@ApiImplicitParams({ //
    @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
})
@GetMapping(value = "/trainInfo/status02")
getTianInfoStatus02
    [
    {
        "is_operation": "yes",
        "insert_time": "2022/05/14_08:30:01:316",
        "control_model": "control13",
        "network": "net13",
        "total_train_length": "136",
        "trainNum": "1213",
        "next_station": "安德门",
        "run_model": "run13",
        "lineNum": "12",
        "signal_strength": "zero",
        "is_online": "online",
        "collect_time": "2022/05/14_08:30:01:316",
        "current_station": "中华门",
        "status": "fault"
    },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:001",
            "control_model": "control01",
            "network": "net01",
            "total_train_length": "55",
            "trainNum": "1201",
            "next_station": "东南大学",
            "run_model": "run01",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2021/3/12_09:51:001",
            "current_station": "南京大学",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:012",
            "control_model": "control12",
            "network": "net12",
            "total_train_length": "108",
            "trainNum": "1212",
            "next_station": "中华门",
            "run_model": "run12",
            "lineNum": "12",
            "signal_strength": "weak",
            "is_online": "offline",
            "collect_time": "2021/3/14_09:51:012",
            "current_station": "三山街",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:40:41:773",
            "control_model": "control01",
            "network": "net01",
            "total_train_length": "55",
            "trainNum": "1201",
            "next_station": "东南大学",
            "run_model": "run01",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:40:41:773",
            "current_station": "南京大学",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control01",
            "network": "net01",
            "total_train_length": "55",
            "trainNum": "1201",
            "next_station": "东南大学",
            "run_model": "run01",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "南京大学",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control02",
            "network": "net02",
            "total_train_length": "63",
            "trainNum": "1202",
            "next_station": "南京南",
            "run_model": "run02",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "东南大学",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control03",
            "network": "net03",
            "total_train_length": "86",
            "trainNum": "1203",
            "next_station": "玄武湖",
            "run_model": "run03",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "南京南",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control04",
            "network": "net04",
            "total_train_length": "58",
            "trainNum": "1204",
            "next_station": "南京站",
            "run_model": "run04",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "玄武湖",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control05",
            "network": "net05",
            "total_train_length": "95",
            "trainNum": "1205",
            "next_station": "秦皇庙",
            "run_model": "run05",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "南京站",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control06",
            "network": "net06",
            "total_train_length": "105",
            "trainNum": "1206",
            "next_station": "鼓楼",
            "run_model": "run06",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "玄武湖",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control07",
            "network": "net07",
            "total_train_length": "73",
            "trainNum": "1207",
            "next_station": "鸡鸣寺",
            "run_model": "run07",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "鼓楼",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control08",
            "network": "net08",
            "total_train_length": "82",
            "trainNum": "1208",
            "next_station": "珠江路",
            "run_model": "run08",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "鸡鸣寺",
            "status": "fault"
        },
        {
            "is_operation": "yes",
            "insert_time": "2022/05/14_07:56:14:912",
            "control_model": "control09",
            "network": "net09",
            "total_train_length": "51",
            "trainNum": "1209",
            "next_station": "新街口",
            "run_model": "run09",
            "lineNum": "12",
            "signal_strength": "zero",
            "is_online": "online",
            "collect_time": "2022/05/14_07:56:14:912",
            "current_station": "珠江路",
            "status": "fault"
        }
    ]

//9查询所有预警状态的列车
@ApiOperation(value = "查询预警状态的列车", notes = "查询所有预警状态的列车")
//@ApiImplicitParam(name = "trainNum", value = "trainNum", required = true, dataType = "String")
@ApiImplicitParams({ //
    @ApiImplicitParam(name = "lineNum", value = "线路ID：lineNum", required = true, dataType = "String"),
})
@GetMapping(value = "/trainInfo/status03")
getTianInfoStatus03
    [
    {
        "is_operation": "yes",
        "insert_time": "2021/3/14_09:51:003",
        "control_model": "control03",
        "network": "net03",
        "total_train_length": "43",
        "trainNum": "1203",
        "next_station": "玄武湖",
        "run_model": "run03",
        "lineNum": "12",
        "signal_strength": "medium",
        "is_online": "online",
        "collect_time": "2021/3/14_09:51:003",
        "current_station": "南京南",
        "status": "warning"
    },
        {
            "is_operation": "yes",
            "insert_time": "2021/3/14_09:51:013",
            "control_model": "control13",
            "network": "net13",
            "total_train_length": "74",
            "trainNum": "1213",
            "next_station": "安德门",
            "run_model": "run13",
            "lineNum": "12",
            "signal_strength": "strong",
            "is_online": "offline",
            "collect_time": "2021/3/14_09:51:013",
            "current_station": "中华门",
            "status": "warning"
        }
    ]

