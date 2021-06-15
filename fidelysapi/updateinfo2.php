<?php
if ($_SERVER['REQUEST_METHOD']=='POST')
{
	include "bd.php";
    $id=$_POST['id'];
	$cin=$_POST['cin'];
    $adr=$_POST['adr'];
    $teld=$_POST['teld'];
	$telm=$_POST['telm'];
	$pays=$_POST['pays'];
	$ville=$_POST['ville'];
	$cp=$_POST['cp'];
	$nationalite=$_POST['nationalite'];
	$sql="UPDATE client SET cin='$cin', adressedomicile='$adr', teldomicile='$teld', telmobile='$telm', ville='$ville', codepostal='$cp' , nationalite='$nationalite', pays='$pays' where id='$id'";
	$res=$bd->exec($sql);
}

?>