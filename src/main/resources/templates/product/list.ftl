 <!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>产品列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="../../favicon.ico">
    <link href="../../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="../../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="../../css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../../css/animate.min.css" rel="stylesheet">
    <link href="../../css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">

        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>产品列表</h5>
                        <div class="ibox-tools">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="table_basic.html#">导入Excel</a>
                                </li>
                                <li><a onclick="exportProducts()" >导出Excel</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>名称</th>
                                    <th>价格</th>
                                    <th>产品描述</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <#if productList??>
                                    <#list productList as product>
                                        <tr>
                                            <td> ${product.id!}</td>
                                            <td> ${product.name!}</td>
                                            <td> ${product.price!}</td>
                                            <td> ${product.description!}</td>
                                            <td> ${product.createTime!}</td>
                                            <td>查看 编辑</td>
                                        </tr>
                                    </#list>
                                </#if>
                            </tbody>
                            <tfoot>
                            <tr>
                                <th colspan="6"></th>
                            </tr>
                            </tfoot>
                        </table>

                    </div>
                </div>
            </div>

        </div>

    </div>
    <div id="paginate"></div>
    <script src="../../js/jquery.min.js?v=2.1.4"></script>
    <script src="../../js/bootstrap.min.js?v=3.3.6"></script>
    <script src="../../js/plugins/peity/jquery.peity.min.js"></script>
    <script src="../../js/content.min.js?v=1.0.0"></script>
    <script src="../../js/plugins/iCheck/icheck.min.js"></script>
    <script src="../../js/demo/peity-demo.min.js"></script>
    <script src="../../js/plugins/layer/layer.min.js"></script>
    <script src="../../js/pagination.js"></script>
    <script>
        $(function(){
            $('#paginate').pagination({
                dataSource: function(done) {
                    $.ajax({
                        type: 'GET',
                        url: '/product/list',
                        success: function(response) {
                            console.log("dataSource", response);
                            done(response);
                        }
                    });
                },
                totalNumber: 24,
                pageNumber: 1,
                pageSize: 10,
                pageRange: 2,
                showPrevious: true,
                showNext: true,
                showPageNumbers: true,
                showGoInput: true,
                showGoButton: true,
                autoHidePrevious: true,
                autoHideNext: true,
                prevText: "上一页",
                nextText: "下一页",
                callback: function(data, pagination) {
                   console.log(data, pagination);
                }
            })
        })
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
        function exportProducts() {
            $.post("/export/products",function (result) {
                console.log(result);
            });
        }

    </script>
</body>

</html>
