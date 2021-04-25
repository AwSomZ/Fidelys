<?php
if ($_SERVER['REQUEST_METHOD']=='POST')
{
	include "bd.php";
    	$id=$_POST['id'];
	$cin=$_POST['cin'];
    	$adr=$_POST['adr'];
    	$teld=$_POST['teld'];
	$telm=$_POST['telm'];
	$telp=$_POST['telp'];
	$pays=$_POST['pays'];
	$ville=$_POST['ville'];
	$cp=$_POST['cp'];
	$nationalite=$_POST['nationalite'];
	$fonction=$_POST['fonction'];
	$societe=$_POST['societe'];
	$fax=$_POST['fax'];
	$sql="UPDATE client SET cin='$cin', adressedomicile='$adr', teldomicile='$teld', telmobile='$telm' , telprofessionnel='$telp' , ville='$ville', codepostal='$cp' , nationalite='$nationalite', fonction='$fonction', societe='$societe', fax='$fax', pays='$pays' where id='$id'";
	$res=$bd->exec($sql);










}

?>