$(document).ready(function () {
    $("#errorAlert").hide();
    $("#submitBtn").click(function () {
        var query = $("#queryInput").val();
        var settings = {
            "url": "query",
            "method": "POST",
            "timeout": 0,
            "headers": {
                "Content-Type": "application/json"
            },
            "data": JSON.stringify({"query": query, "resourceId": "default.json"}),
        };

        $.ajax(settings)
            .success(function (response) {
                console.log(response);
                var jsonPretty = JSON.stringify(response, null, '\t');
                $("pre").text(jsonPretty);
            })
            .error(function (jqxhr) {
                var badRp = JSON.parse(jqxhr.responseText);
                console.log(badRp);
                console.log(badRp.message);
                $('#errorAlert').text(badRp.message);
                $('#errorAlert').show();
                setTimeout(function(){
                    $('#errorAlert').hide();
                }, 5000);
            });
    });
});