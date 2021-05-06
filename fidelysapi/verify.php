<?php
    if(isset($_GET['vkey'])) 
        {
            include "bd.php";
                $vkey=$_GET['vkey'];
                $query=$bd->prepare("select * from user where vkey='$vkey';");
                $query->execute();
                if($query->rowCount()>0)
                    {
                        $data=$query->fetchAll(PDO::FETCH_ASSOC);
                        $cin=$data[0]['id'];
                        $sexe=$data[0]['sexe'];
                        $nom=$data[0]['nom'];
                        $prenom=$data[0]['prenom'];
                        $date=$data[0]['datenaiss'];
                        $email=$data[0]['email'];
                        $nationalite=$data[0]['nationalite'];
                        $adr=$data[0]['adressedomicile'];
                        $ville=$data[0]['ville'];
                        $cp=$data[0]['codepostal'];
                        $pays=$data[0]['pays'];
                        $teld=$data[0]['teldomicile'];
                        $telm=$data[0]['telmobile'];
                        $societe=$data[0]['societe'];
                        $fonction=$data[0]['fonction'];
                        $telp=$data[0]['telprofessionnel'];
                        $fax=$data[0]['fax'];
                        $langue=$data[0]['langue'];
                        $pref=$data[0]['preference'];
                        $paiement=$data[0]['paiement'];
                        $hab=$data[0]['habitude'];
                        $classh=$data[0]['classeh'];
                        $assistance=$data[0]['assistance'];
                        $type=$data[0]['type'];
                        //id 
                        $nbr=$bd->prepare("select * from client;");
                        $nbr->execute();
                        $c = $nbr->rowCount();
                        do 
                            {
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
                                $pin = (string) rand(100000000,999999999);
                                $ok=$bd->prepare("select * from client where id='$code' or pin='$pin';");
                                $ok->execute();
                            }
                        while($ok->rowCount()>0);
                        $update = "UPDATE user set verified= 1 where vkey='$vkey' ";    
                        $res=$bd->exec($update);
                        $sq="insert into client (`id`, `pin`, `cin`, `sexe`, `nom`, `prenom`, `datenaiss`, `email`, `nationalite`, `adressedomicile`, `ville`, `codepostal`, `pays`, `teldomicile`, `telmobile`, `societe`, `fonction`, `telprofessionnel`, `fax`, `langue`, `preference`, `paiement`, `habitude`, `classeh`, `assistance`, `type`) VALUES 
                        ('$code','$pin','$cin','$sexe','$nom','$prenom','$date','$email','$nationalite','$adr','$ville','$cp','$pays','$teld','$telm','$societe','$fonction','$telp','$fax','$langue','$pref','$paiement','$hab','$classh','$assistance','$type');";
                        $re=$bd->exec($sq);
                        if ($re) 
                            {
                                echo 'verified';
                                echo'your id is: '; echo $code ; echo' your pin is: '; echo $pin;
                                $age= date_diff(date_create('today'),date_create($date))->y;
                                if ($age<=24)
                                    {
                                        $plafond=15000;
                                    }
                                else
                                    {
                                        $plafond=13000;
                                    }
                                $mvt= "insert into mouvement (`milesprime`,`client`,`plafond`) values ('3000','$code','$plafond');";
                                $re=$bd->exec($mvt);
                                $delete = "DELETE from user where vkey='$vkey' ";    
                                $res=$bd->exec($delete);
                            }
                        else 
                            {
                                echo 'error';
                            }
                    }
        }
?>