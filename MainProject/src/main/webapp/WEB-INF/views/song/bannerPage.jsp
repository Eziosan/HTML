<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
                *{margin:0; padding:0;}
        .star{
        display:inline-block;
        width: 30px;height: 60px;
        cursor: pointer;
        background-color: yellow;
        }
        .star_left{
        background: url(http://gahyun.wooga.kr/main/img/testImg/star.png) no-repeat 0 0; 
        background-size: 60px; 
        margin-right: -3px;
        }
        .star_right{
        background: url(http://gahyun.wooga.kr/main/img/testImg/star.png) no-repeat -30px 0; 
        background-size: 60px; 
        margin-left: -3px;
        }
        .star.on{
        background-image: url(http://gahyun.wooga.kr/main/img/testImg/star_on.png);
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){

            alert("왜");
            $(".star").on('click',function(){
                alert("별이 클릭됐어요^^....");
                //0~9까지
                var idx = $(this).index();
                console.log(idx);
                $(".star").removeClass("on");

                //ex - 9가 클릭 -> 10번 돌면서 모든 별점을 색칠.  5클릭 -> 6번 돌면서 모든 별점을 색칠
                for(var i=0; i<=idx; i++){
                    //eq 특정 인덱스 요소 반환
                    $(".star").eq(i).addClass("on");
                }

                star(idx);

            });

              
        });
        
        function star(idx){
           var  star = (idx + 1) * 0.5
            alert("점수 : " + star);
        }
        

        function result(){
            alert("되니??")
        }

    </script>
</head>
<body>
    <h1 class="fuck">장난?</h1>
    <button onclick="result();">버튼</button> 
    <div class="star-box">
        <span class="star star_left"></span>
        <span class="star star_right"></span>
      
        <span class="star star_left"></span>
        <span class="star star_right"></span>
      
        <span class="star star_left"></span>
        <span class="star star_right"></span>
      
       <span class="star star_left"></span>
       <span class="star star_right"></span>
      
       <span class="star star_left"></span>
       <span class="star star_right"></span>
      </div>
</body>
</html>