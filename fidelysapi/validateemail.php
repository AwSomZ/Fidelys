<?php
    if(isset($_GET['client'])) 
        {
            include "bd.php";
            $id=$_GET['client'];
            $newemail=$_GET['newemail'];
            $sql="UPDATE client SET email='$newemail' where id='$id';";
            $res=$bd->exec($sql); 
            if ($res){
                header("Location: http://www.tunisair.com/site/publish/content/article.asp?ID=819");
                exit();}
            else {echo'no';}
        }
?>