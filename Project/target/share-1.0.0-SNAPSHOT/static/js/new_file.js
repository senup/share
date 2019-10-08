var strflag = sessionStorage.getItem('userid');
console.log(strflag);
  function getCookie(userName){
      if (document.cookie.length>0){
        c_start=document.cookie.indexOf(userName+ "=");
        if (c_start!=-1){
          c_start=c_start + userName.length+1;
          c_end=document.cookie.indexOf(";",c_start);
          if (c_end==-1){ 
              c_end=document.cookie.length;
          }
          return unescape(document.cookie.substring(c_start,c_end));
        }
     }
    return "";
}
  var  userName = getCookie('userName');
    console.log( "另一个页面"+userName );