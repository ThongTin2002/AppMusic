<?php
require "connect.php";
class ChuDe{
    public function ChuDe($idchude,$tenchude,$hinhchude)
    {
        $this->idChuDe=$idchude;
        $this->TenChuDe=$tenchude;
        $this->HinhChuDe=$hinhchude;
    }
}
$arraychude=array();
$query="SELECT * FROM chude";
$data=mysqli_query($con,$query);
while($row=mysqli_fetch_assoc($data)){
    array_push($arraychude,new ChuDe($row['idChuDe'],$row['TenChuDe'],$row['HinhChuDe']));
}
echo json_encode($arraychude);
?>