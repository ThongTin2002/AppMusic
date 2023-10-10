<?php
require "connect.php";
    $luotthich = "1";
    $idbaihat = "1";
    $query = "SELECT LuotThich FROM baihat WHERE idBaiHat='$idbaihat'";
    $dataluotthich = mysqli_query($con, $query);
    $row = mysqli_fetch_assoc($dataluotthich);
    $tongluotthich = $row['LuotThich'];

    if(isset($luotthich)){
        $tongluotthich = $tongluotthich + $luotthich;
        $querysum="UPDATE baihat SET LuotThich='$tongluotthich' WHERE idBaiHat='$idbaihat'";
        $dataupdate=mysqli_query($con,$querysum);
        if($dataupdate){
            echo"Thanh cong";
        }
        else{
            echo"That bai";
        }
    }
?>