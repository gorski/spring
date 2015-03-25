<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
<script>
    $(document).ready(function () {
        $("#qrInput").keyup(function () {
            callAjax($(this).val());
        })
    });

    function callAjax(txt) {
        $.ajax({
            url:"<c:url value='/ajax/person' />",
            type:"POST",
            data: JSON.stringify({  "search" : txt }) ,
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(response){
                console.log(response);

                var html = '';

                $.each(response, function( index, value ) {
                    html += value['firstName'];
                    html += ' ';
                    html += value['lastName'];
                    html += "<br/>";
                });

                $("#result").html(html);
            }
        })
    }

</script>
<h2>Ajax call (see console for output)</h2>

<form>
    Type text: <input type="text" value="" id="qrInput"/>
</form>
<div id="result"></div>
</body>
</html>
