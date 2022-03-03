package pet;

import com.akkaserverless.javasdk.AkkaServerless;
import com.akkaserverless.javasdk.valueentity.ValueEntityContext;
import com.akkaserverless.javasdk.view.ViewCreationContext;
import pet.api.PetApi;
import pet.domain.Pet;
import pet.domain.PetProvider;
import pet.view.PetByGenderView;
import pet.view.PetByGenderViewProvider;
import pet.view.PetViewModel;

import java.util.function.Function;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public final class AkkaServerlessFactory {

  public static AkkaServerless withComponents(
      Function<ValueEntityContext, Pet> createPet,
      Function<ViewCreationContext, PetByGenderView> createPetByGenderView) {
    AkkaServerless akkaServerless = new AkkaServerless();
    return akkaServerless
      .register(PetByGenderViewProvider.of(createPetByGenderView))
      .register(PetProvider.of(createPet));
  }
}
