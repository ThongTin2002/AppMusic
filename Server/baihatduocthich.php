<?php
require "connect.php";
$arraycasi=array();
$query="SELECT * FROM baihat ORDER BY LuotThich DESC LIMIT 5";
$data=mysqli_query($con,$query);
class Baihat{
    public function Baihat($idbaihat,$tenbaihat,$hinhbaihat,$casi,$linkbaihat,$luotthich)
    {
        $this->IdBaiHat=$idbaihat;
        $this->TenBaiHat=$tenbaihat;
        $this->HinhBaiHat=$hinhbaihat;
        $this->CaSi=$casi;
        $this->LinkBaiHat=$linkbaihat;
        $this->LuotThich=$luotthich;
    }
}

while($row=mysqli_fetch_assoc($data)){
    array_push($arraycasi,new Baihat($row['idBaiHat'],$row['TenBaiHat'],$row['HinhBaiHat'],$row['CaSi'],$row['LinkBaiHat'],$row['LuotThich']));
}
echo json_encode($arraycasi);
?>