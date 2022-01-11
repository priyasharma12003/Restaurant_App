package com.example.restaurantapp

import android.app.Activity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Permission(val contextactivity: Activity) {

        fun permission2() {

        }

               /* if ((ContextCompat.checkSelfPermission(contextactivity,
                                android.Manifest.permission.READ_EXTERNAL_STORAGE
                        ) +
                                ContextCompat.checkSelfPermission(
                                        contextactivity,
                                        android.Manifest.permission.READ_EXTERNAL_STORAGE
                                )) !=
                        PackageManager.PERMISSION_GRANTED
                ) {
                        //when permission not granted
                        if (ActivityCompat.shouldShowRequestPermissionRationale(
                                        contextactivity,
                                        android.Manifest.permission.CAMERA
                                ) ||
                                ActivityCompat.shouldShowRequestPermissionRationale(
                                        contextactivity,
                                        android.Manifest.permission.READ_EXTERNAL_STORAGE
                                )
                        ) {
                                val builder = android.app.AlertDialog.Builder(contextactivity)
                                builder.setTitle("Grant those permissions")
                                builder.setMessage("Camera and Read Storage")
                                builder.setPositiveButton("ok")
                                { dialogInterface, i ->
                                        ActivityCompat.requestPermissions(
                                                contextactivity,
                                                arrayOf(
                                                        android.Manifest.permission.CAMERA,
                                                        android.Manifest.permission.READ_EXTERNAL_STORAGE
                                                ),
                                                123
                                        )
                                }
                                builder.setNegativeButton("Cancel", null)
                                val alertDialog = builder.create()
                                alertDialog.show()
                        } else {
                        }
                        ActivityCompat.requestPermissions(
                                contextactivity, arrayOf(
                                        android.Manifest.permission.CAMERA,
                                        android.Manifest.permission.READ_EXTERNAL_STORAGE
                                ),
                                123
                        )
                } else {
                        //when permission are granted
                        Toast.makeText(contextactivity, "permission are granted", Toast.LENGTH_LONG)
                                .show()
                }
        }

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
                if (requestCode==123)
                        if (grantResults.size > 0 && ((grantResults[0] + grantResults[1])
                                        == PackageManager.PERMISSION_GRANTED)
                        ) {
                                Toast.makeText(contextactivity,"permission granted",Toast.LENGTH_LONG).show()
                        } else {
                                Toast.makeText(contextactivity,"permission denied",Toast.LENGTH_LONG).show()
                        }
        }
}*/


















































       /*

                fun requestpermission(context: Context) {

                        requestPermission()
                }


                private var permissionsRequired = arrayOf(
                        android.Manifest.permission.CAMERA,
                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                private val PERMISSION_CALLBACK_CONSTANT = 100
                private val REQUEST_PERMISSION_SETTING = 101
                private var permissionStatus: SharedPreferences? = null
                private var sentToSettings = false

                private fun requestPermission() {
                        if (ActivityCompat.checkSelfPermission(
                                        contextg,
                                        permissionsRequired[0]
                                ) != PackageManager.PERMISSION_GRANTED
                                || ActivityCompat.checkSelfPermission(
                                        contextg,
                                        permissionsRequired[1]
                                ) != PackageManager.PERMISSION_GRANTED
                                || ActivityCompat.checkSelfPermission(
                                        contextg,
                                        permissionsRequired[2]
                                ) != PackageManager.PERMISSION_GRANTED
                        ) {
                                if (ActivityCompat.shouldShowRequestPermissionRationale(
                                                contextactivity,
                                                permissionsRequired[0]
                                        )
                                        || ActivityCompat.shouldShowRequestPermissionRationale(
                                                contextactivity,
                                                permissionsRequired[1]
                                        )
                                        || ActivityCompat.shouldShowRequestPermissionRationale(
                                                contextactivity,
                                                permissionsRequired[2]
                                        )
                                ) {
                                        //Show Information about why you need the permission
                                        getAlertDialog()
                                } else if (permissionStatus!!.getBoolean(
                                                permissionsRequired[0],
                                                false
                                        )
                                ) {
                                        //Previously Permission Request was cancelled with 'Dont Ask Again',
                                        // Redirect to Settings after showing Information about why you need the permission
                                        val builder = AlertDialog.Builder(contextg)
                                        builder.setTitle("Need Multiple Permissions")
                                        builder.setMessage("This app needs permissions.")
                                        builder.setPositiveButton("Grant") { dialog, which ->
                                                dialog.cancel()
                                                sentToSettings = true
                                                val intent =
                                                        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                                                val uri =
                                                        Uri.fromParts("package", packageName, null)
                                                intent.data = uri
                                                startActivityForResult(
                                                        intent,
                                                        REQUEST_PERMISSION_SETTING
                                                )
                                                Toast.makeText(
                                                        contextg,
                                                        "Go to Permissions to Grant ",
                                                        Toast.LENGTH_LONG
                                                ).show()
                                        }
                                        builder.setNegativeButton("Cancel") { dialog, which -> dialog.cancel() }
                                        builder.show()
                                } else {
                                        //just request the permission
                                        ActivityCompat.requestPermissions(
                                                contextactivity,
                                                permissionsRequired,
                                                PERMISSION_CALLBACK_CONSTANT
                                        )
                                }

                                //   txtPermissions.setText("Permissions Required")

                                val editor = permissionStatus!!.edit()
                                editor.putBoolean(permissionsRequired[0], true)
                                editor.commit()
                        } else {
                                //You already have the permission, just go ahead.
                                Toast.makeText(
                                        contextg,
                                        "Allowed All Permissions",
                                        Toast.LENGTH_LONG
                                ).show()
                        }
                }

                override fun onRequestPermissionsResult(
                        requestCode: Int,
                        permissions: Array<String>,
                        grantResults: IntArray
                ) {
                        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
                        if (requestCode == PERMISSION_CALLBACK_CONSTANT) {
                                //check if all permissions are granted
                                var allgranted = false
                                for (i in grantResults.indices) {
                                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                                                allgranted = true
                                        } else {
                                                allgranted = false
                                                break
                                        }
                                }

                                if (allgranted) {
                                        Toast.makeText(
                                                contextg,
                                                "Allowed All Permissions",
                                                Toast.LENGTH_LONG
                                        ).show()
                                } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                                                contextactivity,
                                                permissionsRequired[0]
                                        )
                                        || ActivityCompat.shouldShowRequestPermissionRationale(
                                                contextactivity,
                                                permissionsRequired[1]
                                        )
                                        || ActivityCompat.shouldShowRequestPermissionRationale(
                                                contextactivity,
                                                permissionsRequired[2]
                                        )
                                ) {

                                        getAlertDialog()
                                } else {
                                        Toast.makeText(
                                                contextg,
                                                "Unable to get Permission",
                                                Toast.LENGTH_LONG
                                        ).show()
                                }
                        }
                }

                private fun getAlertDialog() {
                        val builder = AlertDialog.Builder(contextg)
                        builder.setTitle("Need Multiple Permissions")
                        builder.setMessage("This app needs permissions.")
                        builder.setPositiveButton("Grant") { dialog, which ->
                                dialog.cancel()
                                ActivityCompat.requestPermissions(
                                        contextactivity,
                                        permissionsRequired,
                                        PERMISSION_CALLBACK_CONSTANT
                                )
                        }
                        builder.setNegativeButton("Cancel") { dialog, which -> dialog.cancel() }
                        builder.show()
                }

                override fun onPostResume() {
                      //  super.onPostResume()
                        if (sentToSettings) {
                                if (ActivityCompat.checkSelfPermission(
                                                contextg,
                                                permissionsRequired[0]
                                        ) == PackageManager.PERMISSION_GRANTED
                                ) {
                                        //Got Permission
                                        Toast.makeText(
                                                contextg,
                                                "Allowed All Permissions",
                                                Toast.LENGTH_LONG
                                        ).show()
                                }
                        }
                }*/

        }

