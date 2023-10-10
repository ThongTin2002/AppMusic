<?php
require "connect.php";
$query="SELECT quangcao.id,quangcao.HinhAnh,quangcao.NoiDung,quangcao.idBaiHat,baihat.TenBaiHat,baihat.HinhBaiHat FROM `baihat`INNER JOIN quangcao ON quangcao.idBaiHat=baihat.idBaiHat WHERE quangcao.idBaiHat=baihat.idBaiHat";
$data=mysqli_query($con,$data);

class Quangcao{
    public function Quangcao($idquangcao,$hinhanh,$noidung,$idbaihat,$tenbaihat,$hinhbaihat)
    {
        $this->IdQuangCao=$idquangcao;
        $this->Hinhanh=$hinhanh;
        $this->Noidung=$noidung;
        $this->IdBaiHat=$idbaihat;
        $this->TenBaiHat=$tenbaihat;
        $this->HinhBaiHat=$hinhbaihat;
    }
}
    $mangquangcao=array();
    while($row=mysqli_fetch_assoc($data)){
        array_push($mangquangcao,new Quangcao($row['Id'],$row['Hinhanh'],$row['Noidung'],$row['IdBaiHat'],$row['TenBaiHat'],$row['HinhBaiHat']));
    }
    echo json_encode($mangquangcao);
?>