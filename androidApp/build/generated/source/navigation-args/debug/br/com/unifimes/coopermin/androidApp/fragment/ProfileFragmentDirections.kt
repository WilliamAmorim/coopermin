package br.com.unifimes.coopermin.androidApp.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import br.com.unifimes.coopermin.androidApp.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionProfileFragmentToContratosActivity2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileFragment_to_contratosActivity2)

    public fun actionProfileFragmentToSettingActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileFragment_to_settingActivity)
  }
}
