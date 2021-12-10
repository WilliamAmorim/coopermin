package br.com.unifimes.coopermin.androidApp.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import br.com.unifimes.coopermin.androidApp.R

public class HomeAssociadoFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeAssociadoFragmentToContratosActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeAssociadoFragment_to_contratosActivity)

    public fun actionHomeAssociadoFragmentToSettingActivity2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeAssociadoFragment_to_settingActivity2)

    public fun actionHomeAssociadoFragmentToAssociadoActivity(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeAssociadoFragment_to_associadoActivity)
  }
}
