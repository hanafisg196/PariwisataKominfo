package com.example.pariwisatakominfo.ui

import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@SuppressLint("InlinedApi")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionScreen(navController: NavHostController) {
    RequestPermissions(
        permissions = listOf(

            Manifest.permission.POST_NOTIFICATIONS,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION



        ),
        deniedMessage = "Berikan izin pada aplikasi ini untuk melanjutkan. Jika tidak berhasil, Anda harus melakukannya secara manual dari pengaturan.",
        rationaleMessage = "Untuk menggunakan fungsi aplikasi ini, Anda perlu memberi kami izin.",
        navController

    )
}
