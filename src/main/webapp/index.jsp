<%@page contentType="text/html; charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AJAX JsonArray Example</title>
        <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <link href="css/style_index.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#tablediv").hide();
                $("#showTable").click(function (event) {
                    $.get('WriteServlet', function (responseJson) {
                        if (responseJson !== null) {
                            $("#countrytable").find("tr:gt(0)").remove();
                            var table1 = $("#countrytable");
                            $.each(responseJson, function (key, value) {
                                var rowNew = $("<tr><td></td><td></td><td></td></tr>");
                                rowNew.children().eq(0).text(value['id']);
                                rowNew.children().eq(1).text(value['client_id']);
                                rowNew.children().eq(2).text(value['message']);
                                rowNew.appendTo(table1);
                            });
                        }
                    });
                    $("#tablediv").show();
                });
            });
        </script>
    </head>
    <body class="container">
        <h1>Онлайн чат</h1>
        <input type="button" value="Show Table" id="showTable"/>
        <div id="tablediv">
            <table cellspacing="0" id="countrytable">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">client_id</th>
                    <th scope="col">message</th>
                </tr>
            </table>
        </div>
    </body>
</html>