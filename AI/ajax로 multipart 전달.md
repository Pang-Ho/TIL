1. ajax로 multipart 방식으로 보낼 때, processData는 일반적으로 서버에 전달되는 data는 query String 형태로 전달되어 집니다.
			   data 파라미터로 전달된 데이터는 jQuery 내부적으로 쿼리스트링으로 만들어 보내는데, 파일전송에는 이를 피해야함으로 false로 설정해줍니다.
   2. contentType은 default 값이 "application/x-www-form = urlencoded; charset = UTF-8" 이므로, 보내줄 때
       	   			multipart/form-data로 전송해야 하기 때문에 false로 설정해줍니다.

```jsp
<div>
	<button id="record_start">음성질문 시작</button>
	<button id="record_stop">음성질문 종료</button>
</div>
<!-- 음성질문 처리 -->
    <div id="sound-clips"></div>
    <script>
        const record = document.getElementById("record_start") //제이쿼리는 이렇게 $("#record").jquery함수 $("#record").get(0).dom함수 
        const stop = document.getElementById("record_stop")

        if (navigator.mediaDevices) {
           console.log('getUserMedia supported.')
            const constraints = { audio: true } //녹음기를 사용하겠다
            
       let chunks = []
       navigator.mediaDevices.getUserMedia(constraints)
           .then(function(stream) {
               const mediaRecorder = new MediaRecorder(stream)//녹음기
               record.onclick = function() {//녹음 버튼 클릭시에
                   mediaRecorder.start()// 음성 녹음 시작하라
                   console.log(mediaRecorder.state)
                   console.log("recorder started")
                   record.style.background = "red"
                   record.style.color = "black"
               }//record.onclick
               
               stop.onclick = function() {//정지 버튼 클릭시에
                   mediaRecorder.stop()//녹음 정지시켜라
                   console.log(mediaRecorder.state)
                   console.log("recorder stopped")
                   record.style.background = ""
                   record.style.color = ""
               }//stop.onclick
             
             //녹음 시작시킨 상태가 되면 chunks에 녹음 데이터를 저장하라 
             mediaRecorder.ondataavailable = function(e) {
               chunks.push(e.data)
             }  
               
			//음성 질문 종료가 되면 실행하라
            mediaRecorder.onstop = function(e) {
              console.log("data available after MediaRecorder.stop() called.")
               
               //2. chunk 배열에 녹음 내용이 들어가 있다. blob데이터를 가져온다
               const blob = new Blob(chunks, {'type' : "audio/mp3"});
               //4. 다음 녹음을 위해 chunks 비워둔다
               chunks = []; //리셋해줘야 전 꺼 안 가져옴
               //5. 파일 저장한다
			   var a = document.createElement('a')//<audio src="mp파일명" 
			   soundClips.appendChild(a); //div 태그 내부 audio 태그 추가한다 다음에 a태그 추가한다
			  
			   a.href=mp3URL;
			   a.innerHTML = "MP3파일로 저장";
			   //5.5 파일 이름에 날짜 적용
			   
			   var now = new Date();
			   var year = now.getFullYear();
			   var month = ('0'+(now.getMonth() + 1)).slice(-2);
			   var day = ('0'+now.getDate()).slice(-2);
			   var h = now.getHours();
			   var m = now.getMinutes();
			   var dateString = year +""+ month +""+ day +""+ h +""+ m;
			   
			   var mp3file = "chatbot" + dateString + ".mp3";
               var formData = new FormData();//js FormData함수는 <form> 태그 대신하는 js객체임
               formData.append("file", blob, mp3file);//<input type=file name=mp3file> 이거랑 같은거임
               
			   //6. 스프링 서버로 업로드 = ajax로 요청
			   $.ajax({
				  url:'/mp3upload',
				  data : formData,//{"file":, blob, mp3file} 이렇게 데이터를 열거 못하기때문에 위에서 formData로 보내려고 쓰는거임
				  type : 'post',
				  processData : false,
				  contentType : false,//기본양식을 쓰지 않겠다
				  success:function(server){
					  alert(server)
				  }
				  
			   });
```

