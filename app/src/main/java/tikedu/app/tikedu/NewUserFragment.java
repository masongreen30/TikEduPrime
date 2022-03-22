package tikedu.app.tikedu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import tikedu.app.tikedu.databinding.FragmentNewUserBinding;

public class NewUserFragment extends Fragment {

private FragmentNewUserBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentNewUserBinding.inflate(inflater, container, false);
        ///////
        // go to "home" screen after pressing sign in button
//        Button testingSignInBtn = binding.findViewById(R.id.testingButton);
//        testingSignInBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(getActivity(), StudentHomeActivity.class);
//                getActivity().startActivity(intent);
//
//            }
//        });
        ////////
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.testingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // an intent is "what we want to happen" - intent is to go to home screen
                // Intent(ApplicationContext, SomeClass)
                Intent startIntent = new Intent(getActivity(), StudentHomeActivity.class);
                startActivity(startIntent);
            }

        });

        //navigates to sign up fragment
        binding.signUpNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NewUserFragment.this)
                        .navigate(R.id.action_newUserFragment_to_signUpFragment);
            }
        });

        //navigates to sign in fragment
        binding.signInNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NewUserFragment.this)
                        .navigate(R.id.action_newUserFragment_to_signInFragment);
            }
        });
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}