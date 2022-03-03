package pet.view;

import com.akkaserverless.javasdk.view.View;
import pet.domain.PetDomain;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public abstract class AbstractPetByGenderView extends View<PetDomain.PetState> {

  @Override
  public PetDomain.PetState emptyState() {
    return null; // emptyState is only used with transform_updates=true
  }


}

