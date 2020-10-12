package eif.viko.lt.auto.Fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import eif.viko.lt.auto.R
import kotlinx.android.synthetic.main.fragment_login.*



const val RC_SIGN_IN = 123
const val TAG = "AUTOMOBILIU APPSAS"
class LoginFragment : Fragment(R.layout.fragment_login) {


    private val db = FirebaseFirestore.getInstance()

    private val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build(),
        AuthUI.IdpConfig.GoogleBuilder().build())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // signin.setOnClickListener {

            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(),
                RC_SIGN_IN)

            //Toast.makeText(context, "HELLO", Toast.LENGTH_LONG).show()
       // }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                Toast.makeText(context, "USer: ${user?.uid}", Toast.LENGTH_LONG).show()

                val city = hashMapOf(
                    "name" to "BMW X5",
                    "state" to "UK",
                    "country" to "USA"
                )

                db.collection("automobiliai").document("bmw")
                    .set(city)
                    .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
                    .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

                db.collection("automobiliai").document("opel")
                    .set(city)
                    .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
                    .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

                db.collection("automobiliai").document("fiat")
                    .set(city)
                    .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
                    .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }



//                val docRef = db.collection("automobiliai").document("bmw")
//                docRef.get()
//                    .addOnSuccessListener { document ->
//                        if (document != null) {
//                            Log.d(TAG, "DocumentSnapshot data: ${document.data?.get("name")}")
//                        } else {
//                            Log.d(TAG, "No such document")
//                        }
//                    }
//                    .addOnFailureListener { exception ->
//                        Log.d(TAG, "get failed with ", exception)
//                    }



                db.collection("automobiliai")
                    .get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            Log.d(TAG, "${document.id} => ${document.data["name"]}")
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.w(TAG, "Error getting documents: ", exception)
                    }






                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

                // ...
            } else {
                Toast.makeText(context, "NEPAVYKO", Toast.LENGTH_LONG).show()

                // findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
}