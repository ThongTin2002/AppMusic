<?php
    require "connect.php";
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
    $arraydanhsachbaihat=array();
    if(isset($_POST['idtheloai'])){
        $idtheloai=$_POST['idtheloai'];
        $query="SELECT * FROM baihat WHERE FIND_IN_SET('$idtheloai',idTheLoai)";
    }

    if(isset($_POST['idplaylist'])){
        $idplaylist=$_POST['idplaylist'];
        $query="SELECT * FROM baihat WHERE FIND_IN_SET('$idplaylist',idPlayList)";
    }

    if(isset($_POST['idquangcao'])){
        $idquangcao=$_POST['idquangcao'];
        $queryquangcao="SELECT * FROM quangcao WHERE Id='$idquangcao'";
        $dataquangcao=mysqli_query($con,$queryquangcao);
        $rowquangcao=mysqli_fetch_assoc($dataquangcao);
        $id=$rowquangcao['idBaiHat'];
        $query="SELECT * FROM baihat WHERE idBaiHat ='$id'";
    }
    $data=mysqli_query($con,$query);
    while($row=mysqli_fetch_assoc($data)){
        array_push($arraydanhsachbaihat,new Baihat($row['idBaiHat'],$row['TenBaiHat'],$row['HinhBaiHat'],$row['CaSi'],$row['LinkBaiHat'],$row['LuotThich']));
    }
    echo json_encode($arraydanhsachbaihat);
?>