<?php
    if ($_SERVER['REQUEST_METHOD']=='POST')
        {
            include "bd.php";
            $client=$_POST['client'];
            $titre=$_POST['titre'];
            $description=$_POST['description'];
            $datecreation = date("Y-m-d");
            $etat="en cours";
            
            $sql="insert into  reclamation (titre, description, client, datecreation, etat) VALUES
            ('$titre','$description','$client','$datecreation','$etat');";
            $res=$bd->exec($sql);
           
        }
?>