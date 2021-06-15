<?php
	include "bd.php";
	$id=$_POST['client'];
	$query=$bd->prepare("select * from  mouvement   where client='$id' ");
	$query->execute();
	if ($query->rowCount()>0)
		{
			$data=$query->fetchAll(PDO::FETCH_ASSOC);
			$cummul=(int)$data[0]['soldecummule'];
			$plafond=(int)$data[0]['plafond'];
			$dateniv=$data[0]['date_niveau'];
			$statut=$data[0]['statut'];
			$seuil=$data[0]['seuil'];
			$today=date("Y-m-d");
			$dateniv = strtotime($dateniv);
			$delai = strtotime('+ 1 year', $dateniv);
			$del=date("Y-m-d",$delai);
			if ($today>=$del) 
					{
						if ($cummul<$seuil)
							{
								$cummul=0;
								if ($statut=='silver')
									{
										$statut='classic'; 
										if($plafond==30000)
											{
												$plafond=15000;
												$seuil=0;
											}
										else 
											{
												$plafond=13000;
												$seuil=0;
											}
									} 
								else if($statut=='gold')
									{
										$statut='silver';
										if($plafond==30000)
											{
												
												$seuil=15000;
											}
										else 
											{
												
												$seuil=13000;
											}
									}
								$update = "UPDATE mouvement set plafond='$plafond',statut='$statut', soldecummule='$cummul',seuil='$seuil', date_niveau='$del' where client='$id' "; 
							}
						else 
							{
								$update = "UPDATE mouvement set  date_niveau='$del' where client='$id' ";
							}
					$res=$bd->exec($update); 
				}
		}
	$query->execute();
	if ($query->rowCount()>0)
		{
			$data=$query->fetchAll(PDO::FETCH_ASSOC);
			echo json_encode($data[0]);
		}
?>