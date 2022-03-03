package pet.view;

import com.akkaserverless.javasdk.impl.view.UpdateHandlerNotFound;
import com.akkaserverless.javasdk.impl.view.ViewRouter;
import com.akkaserverless.javasdk.view.View;
import pet.domain.PetDomain;

// This code is managed by Akka Serverless tooling.
// It will be re-generated to reflect any changes to your protobuf definitions.
// DO NOT EDIT

public class PetByGenderViewRouter extends ViewRouter<PetDomain.PetState, PetByGenderView> {

  public PetByGenderViewRouter(PetByGenderView view) {
    super(view);
  }

  @Override
  public View.UpdateEffect<PetDomain.PetState> handleUpdate(
      String eventName,
      PetDomain.PetState state,
      Object event) {

    switch (eventName) {

      default:
        throw new UpdateHandlerNotFound(eventName);
    }
  }

}

