package br.com.unifimes.coopermin.androidApp

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class MainActivityDirections private constructor() {
  public companion object {
    public fun actionMainActivityToLoginActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainActivity_to_loginActivity)

    public fun actionMainActivityToHomeActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainActivity_to_homeActivity)
  }
}
