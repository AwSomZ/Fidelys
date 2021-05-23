<?php
	include "bd.php";
	$buyer=$_POST['id'];
	$id=$_POST['client'];
	$type=$_POST['type'];
	$quantite=(int)$_POST['quantite'];
	$query=$bd->prepare("select * from  mouvement   where client='$id' ");
	$query->execute();
	if ($query->rowCount()>0)
		{
			$data=$query->fetchAll(PDO::FETCH_ASSOC);
			$cummul=(int)$data[0]['soldecummule'];
			$plafond=(int)$data[0]['plafond'];
			$dateniv=$data[0]['date_niveau'];
			$statut=$data[0]['statut'];
		}
	$today=date("Y-m-d");
	$dateniv = strtotime($dateniv);
	$delai = strtotime('+ 1 year', $dateniv);
	$del=date("Y-m-d",$delai);		
	if ($type=='prime')
		{$description="Achat des Miles Prime";
			$update = "UPDATE mouvement set milesprime=milesprime+'$quantite' where client='$id' "; 
			$res=$bd->exec($update);  
		}
	else if ($type=='statut')
		{	
			if (($cummul+$quantite>=$plafond) and ($today<$del) and (($statut=='silver')or($statut=='classic')))
				{$description="Achat des Miles Statut";
					$cummul=($cummul+$quantite)-$plafond;
					if($statut=='silver') 
						{	
							$seuil=$plafond;
							$statut='gold';
							$expire = date('Y-m-d',strtotime(date("Y-m-d", mktime()) . " + 365 day"));
						}
					else if ($statut=='classic') 
						{
							$statut="silver";
							if ($plafond==13000)
								{	$seuil=$plafond;
									$plafond=25000;
									if ($cummul>=$plafond) 
										{	
											$seuil=$plafond;
											$statut='gold'; 
											$cummul=$cummul-$plafond;
										}
								}
							else
								{ 	
									$seuil=$plafond;
									$plafond=30000;
									if ($cummul>=$plafond) 
										{
											$seuil=$plafond;
											$statut='gold'; 
											$cummul=$cummul-$plafond;
										}

								}
							$expire = date('Y-m-d',strtotime(date("Y-m-d", mktime()) . " + 365 day"));
						}
					$update = "UPDATE mouvement set milesstatut=milesstatut+'$quantite',seuil='$seuil' ,soldecummule='$cummul',plafond='$plafond',date_expiration='$expire',date_niveau='$today', statut='$statut'  where client='$id' ";
				}

		
			
			else
			{
				$description="Achat des Miles Prime";
				$cummul=$cummul+$quantite;
				$update = "UPDATE mouvement set milesstatut=milesstatut+'$quantite' , soldecummule='$cummul' where client='$id' "; 
			}
			$res=$bd->exec($update);  
		}
		if ($buyer != $id){$description= $description." comme cadeau";}
	$transition = "insert into transaction (`credit`,`client`,`date`,`description`) values ('$quantite','$id','$today','$description');";
	$re=$bd->exec($transition); 
?>