<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/exhibition">
<input type="text" name="eiName" placeholder="이름"><br>
<input type="number" name="eiCharge" placeholder="요금"><br>
<input type="text" name="eiArtist" placeholder="작가"><br>
<input type="text" name="eiContent" placeholder="콘텐트"><br>
<input type="date" name="eiStartDate" placeholder="시작일"><br>
<input type="date" name="eiEndDate" placeholder="끝일"><br>
<input type="time" name="eiStartTime" placeholder="시작시간"><br>
<input type="time" name="eiEndTime" placeholder="끝시간"><br>
<input type="text" name="eiStatus" placeholder="상태"><br>
<input type="number" name="fileInfo.fiNum" placeholder="외부키"><br>
<button>버튼</button>
</form>
</body>
</html>