<?php
require "connect.php";
$query="SELECT * FROM playlist";
$data=mysqli_query($con,$query);
    class Danhsachplaylist{
        public function Danhsachplaylist($idplaylist,$ten,$hinhnen,$hinhicon)
        {
            $this->IdPlaylist=$idplaylist;
            $this->Ten=$ten;
            $this->HinhPlaylist=$hinhnen;
            $this->Icon=$hinhicon;
        }
    }
    $arrayplaylist=array();
    while($row = mysqli_fetch_assoc($data)){
        array_push($arrayplaylist, new Danhsachplaylist($row['idPlayList'],$row['Ten'],$row['HinhNen'],$row['HinhIcon']));
    }
    echo json_encode($arrayplaylist);
?>