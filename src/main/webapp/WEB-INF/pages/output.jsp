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
        
        
        /*----------------------LOADING ANIMATION ------------------------------*/
        #contentArea {
          width: 502px;
        }

        .mbm {
          margin-bottom: 10px;
        }

        ._4-u2 {
          background: #fff;
          border: 1px solid;
          border-color: #e5e6e9 #dfe0e4 #d0d1d5;
          border-radius: 3px;
        }

        ._2iwo {
          padding: 20px;
        }

        ._2iwq {
          -webkit-animation-duration: 1s;
          -webkit-animation-fill-mode: forwards;
          -webkit-animation-iteration-count: infinite;
          -webkit-animation-name: placeHolderShimmer;
          -webkit-animation-timing-function: linear;
          background: #f6f7f8;
          background-image: -webkit-gradient(linear, left center, right center, from(#f6f7f8), color-stop(0.2, #edeef1), color-stop(0.4, #f6f7f8), to(#f6f7f8));
          background-image: -webkit-linear-gradient(left, #f6f7f8 0%, #edeef1 20%, #f6f7f8 40%, #f6f7f8 100%);
          background-repeat: no-repeat;
          background-size: 800px 104px;
          height: 104px;
          position: relative;
        }

        ._2rtk ._2iwq {
          -webkit-animation-name: prideShimmer;
          background-image: -webkit-gradient(linear, center top, center bottom, from(deg), color-stop(0, red), color-stop(0.15, orange), color-stop(0.3, yellow), color-stop(0.45, green), color-stop(0.6, blue), color-stop(0.75, indigo), color-stop(0.8, violet), to(red));
          background-image: -webkit-linear-gradient(135deg, red 0%, orange 15%, yellow 30%, green 45%, blue 60%, indigo 75%, violet 80%, red 100%);
          background-repeat: repeat;
          background-size: 50% auto;
        }

        .direction_rtl ._2iwq {
          -webkit-animation-direction: reverse;
        }

        ._2iwq div {
          background: #fff;
          height: 6px;
          left: 0;
          position: absolute;
          right: 0;
        }

        div._2iwr {
          height: 40px;
          left: 40px;
          right: auto;
          top: 0;
          width: 8px;
        }

        div._2iws {
          height: 8px;
          left: 48px;
          top: 0;
        }

        div._2iwt {
          left: 136px;
          top: 8px;
        }

        div._2iwu {
          height: 12px;
          left: 48px;
          top: 14px;
        }

        div._2iwv {
          left: 100px;
          top: 26px;
        }

        div._2iww {
          height: 10px;
          left: 48px;
          top: 32px;
        }

        div._2iwx {
          height: 20px;
          top: 40px;
        }

        div._2iwy {
          left: 410px;
          top: 60px;
        }

        div._2iwz {
          height: 13px;
          top: 66px;
        }

        div._2iw- {
          left: 440px;
          top: 79px;
        }

        div._2iw_ {
          height: 13px;
          top: 85px;
        }

        div._2ix0 {
          left: 178px;
          top: 98px;
        }

        @-webkit-keyframes placeHolderShimmer {
          0% {
            background-position: -468px 0;
          }

          100% {
            background-position: 468px 0;
          }
        }
        @-webkit-keyframes prideShimmer {
          from {
            background-position: top left;
          }

          to {
            background-position: top right;
          }
        }
        /*----------------------------------------------------------------------*/
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
    </style>
    <script src="../js/jquery-3.2.0.min.js"></script>
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
          <button>Download as PDF</button>
          <button>Download Pie Chart</button>
          <div id="opDiv">
              <div id="contentArea">
                <div class="_4-u2 mbm _2iwp">
                    <div class="_2iwo">
                        <div class="_2iwq">
                            <div class="_2iwr"></div>
                            <div class="_2iws"></div>
                            <div class="_2iwt"></div>
                            <div class="_2iwu"></div>
                            <div class="_2iwv"></div>
                            <div class="_2iww"></div>
                            <div class="_2iwx"></div>
                            <div class="_2iwy"></div>
                            <div class="_2iwz"></div>
                            <div class="_2iw-"></div>
                            <div class="_2iw_"></div>
                            <div class="_2ix0"></div>
                        </div>
                    </div>
                </div>
              </div>

          </div>
      </div>
    </div> 
  </div>
  <script>
      /*
       *  $.ajax({
       *    method: "POST",
       *    url: "localhost:8080/methodName",
       *    success: function(){
       *       onDataReceived(this);
       *    }
       *  });
       *
       */

      function onDataReceived(myJSON){
          myJSON = '${message}';
          var myObj = JSON.parse(myJSON);
          for(var i in myObj){
              var temp = '<div class="ques-div"><div class="row"><div class="one column ques-no">'+i+'</div><div class="eleven columns"><p class="question-text">'+i+'th Question text here</p></div></div><div class="categories">';
              for(var j in myObj[i]){
               temp += '<button>'+j+'</button>';
              }
              temp += '</div></div>';
              document.getElementById('opDiv').innerHTML += temp;
          }
      }
      onDataReceived('');

  </script>


  <!-- End Document
    –––––––––––––––––––––––––––––––––––––––––––––––––– -->
</body>
</html>
