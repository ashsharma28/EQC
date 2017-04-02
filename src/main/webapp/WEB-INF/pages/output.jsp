<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Basic Page Needs
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <meta charset="utf-8">
    <title>EQC | Output</title>
    <meta name="description" content="Output Page">
    <meta name="author" content="EQC Team">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- CSS
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../css/skeleton.css">
    <style>
        @font-face {
            font-family: 'Raleway'; /*a name to be used later*/
            src: url('../css/Raleway-Light.ttf'); /*URL to font*/
        }
        body {
            background-color: #e9eaed;
        }

        body *::selection{
            background: #F5C52C;
        }

        .ques-div{
            height: auto;
            width:460px;
            background: white;
            border: 1px solid;
            border-color: #e5e6e9 #dfe0e4 #d0d1d5;
            border-radius: 3px;
            color: #e9eaed;
            padding: 20px;
            margin-bottom: 10px;
        }
        .ques-no{
            font-size: 2.5em;
            font-weight: bold;
        }
        .question-text{
            margin-top: 20px;
            color: black;
        }
        .categories{
            padding-left: 30px;
        }
        .categories button{
            margin-right: 5px;
            margin-bottom: 5px;
        }
        .viewer1{
            position: fixed;
            top:5%;
            right:20px;
            height: 90%;
            width: 40%;
            margin-left: 50%;
        }
    </style>
    <script src="../js/jquery-3.2.0.min.js"></script>
    <script src="../js/Chart.min.js"></script>
    <!-- Favicon
   –––––––––––––––––––––––––––––––––––––––––––––––––– -->
    <link rel="icon" type="image/png" href="../images/favicon.png">

</head>
<body>

<!-- Primary Page Layout
–––––––––––––––––––––––––––––––––––––––––––––––––– -->
<div class="container">
    <div class="row">
        <div class="six columns" style="margin-top: 15%">
            <h4>Output: <span id="tp">"GATE - 2015"</span> Classification & Analysis</h4>
            <button onclick="window.print(); return false;">DOWNLOAD as pdf</button>
            <button  onclick="chartCreate()">Pie Chart</button>
            <div id="opDiv">


            </div>
        </div>
    </div>
</div>
<div class="viewer1" id="viewer"></div>
<script>
    var keys = [];
    var values = [];
    function onDataReceived(myJSON){
        //-------------------------------------------------------------
        myJSON = '${message}';
        var questions = [];
        var tempJson = myJSON;
        var fuzzySets = [];
        var pos = myJSON.indexOf('{');
        while(pos < tempJson.length){
            pos = tempJson.indexOf('"') + 1;
            tempJson = tempJson.slice(pos);
            questions.push(String(tempJson.slice(0,tempJson.indexOf('"'))));
            pos = tempJson.indexOf(':');
            tempJson = tempJson.slice(pos);
            fuzzySets.push(tempJson.slice(tempJson.indexOf('{'),tempJson.indexOf('}') + 1));
            pos = tempJson.indexOf('}') + 1;
            tempJson = tempJson.slice(pos);
        }
        for(var i=0;i<fuzzySets.length;i++){
            fuzzySets[i] = JSON.parse(fuzzySets[i]);
        }
        //var myObj = JSON.parse(myJSON);
        //----------------------------------------------------------------------------
        for(var i=0;i<questions.length;i++){
            var temp = '<div class="ques-div"><div class="row"><div class="one column ques-no">'+(i+1)+'</div><div class="eleven columns"><p class="question-text">'+questions[i]+'</p></div></div><div class="categories">';
            var data = fuzzySets[i];
            Object.keys(data).forEach(function (key) {
                temp += '<button onclick="wikiThis(&quot;'+key+'&quot;)">'+key+' : '+data[key]+'</button>';
                keys.push(key);
                values.push(data[key]);
            });
            temp += '</div></div>';
            document.getElementById('opDiv').innerHTML += temp;
        }
        //chartCreate();
    }
    onDataReceived('');
    function chartCreate(){
        var subjects = [];
        var weightages = [];
        for(var i=0;i<keys.length;i++){
            if(subjects.indexOf(keys[i]) == -1){// not found
                subjects.push(keys[i]);
                weightages.push(values[i]);
            }
            else{
                weightages[subjects.indexOf(keys[i])] += values[i];
            }
        }
        var data = {
            labels: subjects,
            datasets: [
                {
                    data: weightages,
                    backgroundColor: [
                        "#673ab7","#5677fc","#03a9f4","#00bcd4","#259b24","#009688","#8bc34a","#ffeb3b",
                        "#ffc107","#ff9800","#ff5722","#e51c23"
                    ]
                }]
        };
        document.getElementById('viewer').innerHTML = '<canvas id="myChart" width="400" height="400"></canvas>';
        ctx = document.getElementById('myChart');
        var myPieChart = new Chart(ctx,{
            type: 'pie',
            data: data
        });

    }
    function wikiThis(searchString){
        document.getElementById('viewer').innerHTML = '<div id="results"></div>';
        $res = $('#results');
        $res.on({
            ajaxStart: function() { $res.html("Loading...");   },
            ajaxStop: function() { $res.html(" "); }
        });
        $.ajax({
            url: 'https://en.wikipedia.org/w/api.php',
            data: { action: 'query', list: 'search', srsearch:searchString, srlimit:1, format: 'json' },
            dataType: 'jsonp',
            success: function (x) {
                $res.html(" ");
                if(x.query.searchinfo.totalhits!=0){
                    $('#viewer').html('<iframe height="90%" width="100%" src="https://en.wikipedia.org/wiki/'+x.query.search[0].title+'"></iframe>');
                }
                else{
                    $res.html("No results found :( <br>");
                    if(x.query.searchinfo.suggestionsnippet)
                        $res.append("Did you mean: "+x.query.searchinfo.suggestionsnippet);
                }
            },
            error: function(y){
                alert("Error");
            }
        });
    }
</script>

<!-- End Document
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
