class HourMinute
{
 def hour;
 def minute;
 
 def plus(HourMinute f)
 {
  this.hour=this.hour+f.hour;
  this.minute=f.minute+f.minute;
 }
/* def equal(HourMinute f)
 {
  this.hour=f.hour;
  this.minute=f.minute;
 }*/
 /* def -(HourMinute f,HourMinute g)
 {
  this.hour=f.hour-g.hour;
  this.minute=f.minute-g.minute;
 
 }*/
 }
 
 def t1=new HourMinute(hour:4,minute:35);
 println t1.hour
 println t1.minute
 
 def t2=new HourMinute(hour:3,minute:20);
HourMinute t3=new HourMinute();
 
// t3.plus(t1,t2);
 t3==(t1+t2);
 
 //t3=t1;
 println t1.hour
 println t1.minute
 
 // t3.minus(t1,t2);
 //te=t1-t2;
 
  println t3.hour
println t3.minute