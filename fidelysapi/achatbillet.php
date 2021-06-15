<?php
    if ($_SERVER['REQUEST_METHOD']=='POST')
        {
            include "bd.php";
            $client=$_POST['client'];
            $de=$_POST['de'];
            $vers=$_POST['vers'];
            $type=$_POST['type'];
            $datealler=$_POST['datealler'];
            $dateretour=$_POST['dateretour'];
            $heuredepart=$_POST['heuredepart'];
            $heureretour=$_POST['heureretour'];
            $dateallerc=$datealler." ".$heuredepart.":00";
            $dateretourc=$dateretour." ".$heureretour.":00";
            $classe=$_POST['classe'];
            $prix=$_POST['prix'];
            $dateachat = date("Y-m-d H:i:s");
            $sql="insert into  billet (`depart`, `destination`, `type`, `datealler`, `dateretour`,`classe`, `dateachat`, `client`, `prix`) VALUES
            ('$de','$vers','$type','$dateallerc','$dateretourc','$classe','$dateachat','$client','$prix');";  
            $res=$bd->exec($sql);
            if($res)
                {
                    $payment="UPDATE mouvement SET milesprime=milesprime-'$prix' where client='$client';";
                    $transition = "insert into transaction (`montant`,`client`,`date`,`type`,`description`) values ('$prix','$client','$dateachat','debit','Achat Billet Prime');";
                    $re=$bd->exec($transition);
                    $r=$bd->exec($payment);
                }
        }
?>