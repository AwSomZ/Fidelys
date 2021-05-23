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
            $classe=$_POST['classe'];
            $adulte=(int) $_POST['adulte'];
            $jeune=(int) $_POST['jeune'];
            $prix=$_POST['prix'];
            $enfant=(int) $_POST['enfant'];
            $bebe=(int) $_POST['bebe'];
            $dateachat = date("Y-m-d");
            $sql="insert into  billet (`depart`, `destination`, `type`, `datealler`, `dateretour`,`classe`, `adulte`, `jeune`, `enfant`,`bebe`, `dateachat`, `client`) VALUES
            ('$de','$vers','$type','$datealler','$dateretour','$classe','$adulte','$jeune','$enfant','$bebe','$dateachat','$client');";  
            $res=$bd->exec($sql);
            if($res)
                {
                    $transition = "insert into transaction (`debit`,`client`,`date`,`description`) values ('$prix','$client','$dateachat','Achat Billet Prime');";
                    $re=$bd->exec($transition);
                }
        }
?>