<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../Include/topmenu.jsp" %>
<HTML>
<HEAD>
<TITLE>로그온</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
<script>
	function user_login(){
		if(!user.userid.value){
			alert("아이디를 입력하세요");
			user.userid.focus();
			return;
		}
		if(!user.passwd.value){
			alert("비밀번호를 입력하세요");
			user.passwd.focus();
			return;
		}
		user.submit();
	}
</script>
</HEAD>
<body bgcolor="#FFFFFF" text="#000000" leftmargin=0 
  topmargin=0 onLoad='document.user.userid.focus();'>

<table border="0" width="800">
<tr>
  <td width="20%"  bgcolor="#ecf1ef" valign="top" style="padding-left:0;">
	<!--로그인 영역 삽입-->
	<jsp:include page="../Include/login_form.jsp" /> 
	 
  </td>
  <td width="80%" valign="top">&nbsp;<img src="/Images/img/title1.gif" ><br>    
<TABLE width="683" border="0" cellspacing="0" cellpadding="0" height="265">
<TR>
  <TD width=100>&nbsp;</td>
  <TD>
<TABLE width="683" border="0" cellspacing="0" cellpadding="0" height="265"> 
  <TR> 
    <TD width=100>&nbsp;</TD> 
    <TD> 
      <table width="583" border="0" cellspacing="0" cellpadding="0" height="265"> 
        <tr> 
          <td height="298"> 
            <!-- 상단 타이틀 바 -->
            <table width="100%" border="0" cellspacing="0" cellpadding="0"> 
              <tr> 
                <td width="9"><img src="/Images/img/h_b02.gif" width="9" height="21"></td> 
                <td bgcolor="7aaad5"> 
                  <div align="center"><font color="#FFFFFF"><b>마이페이지 (My Page)</b></font></div> 
                </td> 
                <td width="9"><img src="/Images/img/f_b03.gif" width="9" height="21"></td> 
              </tr> 
            </table> 
            
            <table border="0" cellpadding="0" cellspacing="0" width="550"> 
              <tr> 
                <td bgcolor="#7aaad5"> 
                  <table border="0" cellpadding="3" cellspacing="1" width="99%" height="321"> 
                    
                    <!-- 회원 정보 및 아바타 영역 -->
                    <tr bgcolor="#FFFFFF"> 
                      <td align=CENTER bgcolor="#eff4f8" height="120"> 
                        <table width="480" border="0" cellspacing="0" cellpadding="3"> 
                          <tr valign=middle> 
                            <!-- 아바타 이미지 및 변경 버튼 -->
                            <td width="100" align="center" style="padding-right: 15px;">
                              <!-- JSP 연동 시 기존 등록된 아바타 경로 적용 -->
                              <img src="/Images/avatar/default.gif" width="70" height="70" style="border: 1px solid #7aaad5; border-radius: 4px;"><br>
                              <input type="button" value="아바타 변경" onClick="location.href='/User/avatar_change'" style="width:75px; height:18px; font-size:11px; margin-top:5px; background-color:#ffffff; color:#7aaad5; border:1px solid #7aaad5; cursor:pointer;">
                            </td>
                            <!-- 회원 상세 정보 -->
                            <td width="380">
                              <table width="100%" border="0" cellspacing="0" cellpadding="2">
                                <tr>
                                  <td width="21"><img src="/Images/img/h_bl02.gif" width="18" height="16"></td> 
                                  <td width="70" nowrap><b>회원명</b></td> 
                                  <td>: 홍길동 님 (일반회원)</td> 
                                </tr>
                                <tr>
                                  <td><img src="/Images/img/h_bl02.gif" width="18" height="16"></td> 
                                  <td nowrap><b>아이디</b></td> 
                                  <td>: hong123</td> 
                                </tr>
                                <tr>
                                  <td><img src="/Images/img/h_bl02.gif" width="18" height="16"></td> 
                                  <td nowrap><b>이메일</b></td> 
                                  <td>: hong123@example.com</td> 
                                </tr>
                              </table>
                            </td>
                          </tr> 
                        </table> 
                      </td> 
                    </tr> 
                    
                    <!-- 나의 활동 정보 영역 (작성글 / 댓글수) -->
                    <tr bgcolor="#FFFFFF">
                      <td align="CENTER" bgcolor="#ffffff" height="50">
                        <table width="450" border="0" cellspacing="0" cellpadding="0" style="border:1px dashed #7aaad5; padding:10px 0;">
                          <tr>
                            <td width="50%" align="center" style="border-right:1px solid #eff4f8;">
                              <font color="#555555">내가 작성한 글</font><br>
                              <!-- JSP 연동 시 동적 카운트 변수 삽입 공간 -->
                              <a href="/Board/my_posts" style="text-decoration:none;"><font color="#006F70" size="4"><b>12</b></font> <font color="#aaa" size="1">개</font></a>
                            </td>
                            <td width="50%" align="center">
                              <font color="#555555">내가 작성한 댓글</font><br>
                              <!-- JSP 연동 시 동적 카운트 변수 삽입 공간 -->
                              <a href="/Board/my_comments" style="text-decoration:none;"><font color="#ff7508" size="4"><b>34</b></font> <font color="#aaa" size="1">개</font></a>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    
                    <!-- 마이페이지 주요 메뉴 버튼 영역 -->
                    <tr bgcolor="#FFFFFF"> 
                      <td bgcolor="#ffffff" align=CENTER height="50"> 
                        <table border="0" cellspacing="0" cellpadding="5">
                          <tr>
                            <td><input type="button" value="정보수정" onClick="location.href='/User/user_modify'" style="width:90px; height:30px; background-color:#7aaad5; color:white; border:none; font-weight:bold; cursor:pointer;"></td>
                            <td><input type="button" value="비밀번호변경" onClick="location.href='/User/password_change'" style="width:100px; height:30px; background-color:#7aaad5; color:white; border:none; font-weight:bold; cursor:pointer;"></td>
                            <td><input type="button" value="로그아웃" onClick="location.href='/User/user_logout'" style="width:90px; height:30px; background-color:#a1afbc; color:white; border:none; font-weight:bold; cursor:pointer;"></td>
                          </tr>
                        </table>
                      </td> 
                    </tr> 
                    
                  </table> 
                  
                  <!-- 하단 테두리 바 -->
                  <table width="100%" border="0" cellspacing="0" cellpadding="0"> 
                    <tr> 
                      <td width="9"><img src="/Images/img/h_b04.gif" width="12" height="11"></td> 
                      <td bgcolor="7aaad5" width="612"> 
                        <div align="center"></div> 
                      </td> 
                      <td width="10"><img src="/Images/img/h_b05.gif" width="12" height="11"></td> 
                    </tr> 
                  </table> 
                </td> 
              </tr> 
            </table> 
          </td> 
        </tr> 
      </table> 
    </TD> 
  </TR> 
</TABLE>
	</TD>
</TR>
</TABLE>
</td>
</tr>
</table>
</body>
</html>

