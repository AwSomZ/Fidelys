<?php
    if ($_SERVER['REQUEST_METHOD']=='POST')
        {
            include "bd.php";
            $client=$_POST['client'];
            $titre=$_POST['titre'];
            $description=$_POST['description'];
            
            $sql="insert into  reclamation (titre, description, client) VALUES
            ('$titre','$description','$client');";
            $res=$bd->exec($sql);
           
        }
?>