<?php
include "bd.php";
$nbr=$bd->prepare("select * from client;");
$nbr->execute();
$c = $nbr->rowCount();
 do {
            
                $c=$c+1;
            $count= (string) $c;
            $nb = strlen($count);
            $err =9- $nb ; 
            
            $code="";
            for ($x = 0; $x < $err; $x++)
            {
            $code="0".$code;
            }
            $code=$code.$count;
	 $pin = rand(100000000,999999999);
	$ok=$bd->prepare("select * from client where id='$code' or pin='$pin';");
	$ok->execute();
            }while($ok->rowCount()>0);
echo $code;
echo $pin;
?>