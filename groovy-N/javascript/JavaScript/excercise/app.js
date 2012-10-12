

function getCurrentDateTime() {
    return new Date();
}


function zeroPad(num) {
    return parseInt(num,10) < 10 ? '0' + num : num;
}


function parseDate(date, format) {
    //d m, yyyy HH:MM:ss d
    return format.replace(
        /(d)|(m)|(yyyy)|(HH)|(MM)|(ss)|(ap)/g,
        function (match) {
            switch (match) {
                case 'd':
                    return zeroPad(date.getDate());
                    break;
                case 'm':
                    return zeroPad(date.getMonth() + 1);
                    break;
                case 'yyyy':
                    return date.getFullYear();
                    break;
                case 'HH':
                    return zeroPad(date.getHours() < 12 ? date.getHours() : date.getHours() - 12);
                    break;
                case 'MM':
                    return zeroPad(date.getMinutes());
                    break;
                case 'ss':
                    return zeroPad(date.getSeconds());
                    break;
                case 'ap':
                    return date.getHours() < 12 ? 'AM' : 'PM';
                    break;
            }
        });
}

load = function () {
  //  alert(parseDate(getCurrentDateTime(), "d m, yyyy HH:MM:ss ap"));
    //alert(parseDate(getCurrentDateTime(), "HH:MM:ss ap"));
    // loadText("tdisp",tim);
    pid=setInterval("loadText('tdisp',parseDate(getCurrentDateTime(),'HH:MM:ss ap'))",1000);
};
 /*
load=function ()
{
   var ep=document.getElementById("tdisp") ;
    //ep=parseDate((parseDate(getCurrentDateTime(), "d m, yyyy HH:MM:ss ap")));
    ep.innerHTML=parseDate(getCurrentDateTime(), "d m, yyyy HH:MM:ss ap");

}  */

function loadText(id,Text)
{
   document.getElementById(id).innerHTML=Text;

}
function stopf()
{
    clearInterval(pid);

}

function simplep()
{
   p=prompt("amount");
    q=prompt("Interest_Rate");
    r=prompt("Years");
    s=p*q*r/100;
    alert(s) ;
}

  function fun1()
  {
      bc=document.getElementsByName('t4')[0].value

      var d=new String();

      d=bc.toString();

      var fg=new String();

     t=d.length;    alert(t)

       for(var i=t-1;i>=0;i--)
      {
          fg=fg+d[i];

      }

          // alert(fg);

      //document.getElementById(tdw).innerHTML="a palindrome !!";
      if(d==fg)
      {
          alert("hey it is a palindrome !!!")
          //document.getElementById("tdw").innerHTML="a palindrome !!";
      }
      else
          //document.getElementById("tdw").innerHTML="not a palindrome !!";
      alert("not a palindrome !!!")


  }

     function fun2()
     {
         p=prompt("Enter radius")  ;
         r=3.14*p*p;
         var x=new String();
         x=r+" is the area"
         alert(x)
     }

    function fun3()
    {
        x=prompt("Enter name");
        document.getElementById("t1").value=x;

    }

    function fun4()
    {
       document.getElementById("t8").value=document.getElementById("t7").value

    }

    function fun5()
    {
        var b=new String();
        var c=new String();
        var g=new String();
        //var c=" ";

         if(document.getElementById("t9").value.toString().length<=1)
         {
          b="enter name"
         }

         if(document.getElementById("t10").value<18)
         {
        c=" age must be greater than 18"
         }

            g=b+" "+c;
        if(g!=" ")
             alert(g);

    }

    function fun6()
    {
        document.getElementById("dfg").style.backgroundColor='#84DFC1'
    }

 function fun7()
{
    document.getElementById("dfg").style.backgroundColor='#ffebcd'

}
