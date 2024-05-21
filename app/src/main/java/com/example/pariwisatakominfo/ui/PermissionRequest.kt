package com.example.pariwisatakominfo.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.accompanist.permissions.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.pariwisatakominfo.presentation.navgraph.Screen


@ExperimentalPermissionsApi
@Composable
fun RequestPermissions(
    permissions: List<String>,
    deniedMessage: String = "Berikan izin pada aplikasi ini untuk melanjutkan. Jika tidak berhasil, Anda harus melakukannya secara manual dari pengaturan.",
    rationaleMessage: String = "Untuk menggunakan fungsi aplikasi ini, Anda perlu memberi kami izin.",
    navController: NavHostController

) {
    val multiplePermissionsState = rememberMultiplePermissionsState(permissions)

    HandleRequests(
        multiplePermissionsState = multiplePermissionsState,
        deniedContent = { shouldShowRationale ->
            PermissionDeniedContent(
                deniedMessage = deniedMessage,
                rationaleMessage = rationaleMessage,
                shouldShowRationale = shouldShowRationale,
                onRequestPermission = { multiplePermissionsState.launchMultiplePermissionRequest() }
            )
        },
        navController = navController

    )
}




@ExperimentalPermissionsApi
@Composable
private fun HandleRequests(
    multiplePermissionsState: MultiplePermissionsState,
    deniedContent: @Composable (Boolean) -> Unit,
    navController: NavHostController
) {
    var shouldShowRationale by remember { mutableStateOf(false) }
    val result = multiplePermissionsState.permissions.all {
        shouldShowRationale = it.status.shouldShowRationale
        it.status == PermissionStatus.Granted
    }
    if (result) {
        navController.navigate(Screen.HomeScreen.route)
    } else {
        deniedContent(shouldShowRationale)
    }
}


