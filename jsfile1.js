var knum=9;
function myfunction(str,str1){
var c=prompt("Enter the amount you want to assign to the particular category");
var x=document.getElementsByClassName(str1)[0];
var k=x.getElementsByClassName(str)[0];
var kz=k.getElementsByClassName("text")[0];
k.getElementsByClassName("text")[0].innerHTML=k.getElementsByClassName("text")[0].innerHTML+':';
kz.getElementsByClassName("valu")[0].innerHTML=c;
var bele=k.getElementsByClassName("button")[0];
bele.getElementsByClassName("bname")[0].value='editamount';
var name=k.childNodes[3].id;
document.getElementById(name).value=c;
}
function transitionf(str,str1){
document.querySelector('.model').style.display = "flex";
var x1=document.getElementsByClassName("model")[0];
var k1=x1.getElementsByClassName("model1")[0];
k1.getElementsByClassName("catname")[0].innerHTML=str;
k1.getElementsByClassName("carname")[0].innerHTML=str1;
}
function revtransitionf(){
var x1=document.getElementsByClassName("model")[0];
var k1=x1.getElementsByClassName("model1")[0];
var sd=k1.getElementsByClassName("catname")[0].innerHTML;
var sd1=k1.getElementsByClassName("carname")[0].innerHTML;
var x=document.getElementsByClassName(sd)[0];
var k=x.getElementsByClassName(sd1)[0];
var p=k.cloneNode(true);
var temp=p.getElementsByClassName("text")[0];
temp.getElementsByClassName("valu")[0].innerHTML=k1.getElementsByClassName("textbdecoration")[1].value;
p.getElementsByClassName("text")[0].innerHTML=k1.getElementsByClassName("textbdecoration")[0].value+':'+temp.getElementsByClassName("valu")[0].innerHTML;
var bname=p.getElementsByClassName("button")[0];
bname.getElementsByClassName("bname")[0].value='editamount';
x.appendChild(p);
p.childNodes[1].id="cname"+knum;
p.childNodes[3].id="aname"+knum;
p.childNodes[1].name="cname"+knum;
p.childNodes[3].name="aname"+knum;
document.getElementById("cname"+knum).value=k1.getElementsByClassName("textbdecoration")[0].value;
document.getElementById("aname"+knum).value=k1.getElementsByClassName("textbdecoration")[1].value;
knum++;
document.querySelector('.model').style.display = "none";

}
