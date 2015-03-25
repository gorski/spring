<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
<script>
    $(document).ready(function () {
        $("#qrInput").keyup(function () {
            var txt = 'qr/' + encodeURIComponent($(this).val() === "" ? "http://j-labs.pl" : $(this).val());
            $('#qr').attr('src', txt);
        })
        // typical Ajax call
        // $.post(url, data, success....)
//
//        $.ajax({
//            url: "test",
//            context: document.body
//        }).done(function(x) {
//            alert(x);
//        });

        $.ajax({
            type: "POST",
            url: "test",
            data: {},
            success: function(resp){
                alert(resp);
            },
            dataType: "json"
        });

    });
</script>
<h2>QR generator</h2>

<form>
    Type text: <input type="text" value="" id="qrInput"/>
</form>
<img src="qr/j-labs.pl" alt="QR" id="qr"/>
</body>
</html>
