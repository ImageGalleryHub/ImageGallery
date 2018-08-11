const loginReducer = (state = {}, action) => {
  switch (action.type) {
    case 'LOGIN_FULFILLED': {
      state = {
        ...state,
        username: action.payload.username,
        password: action.payload.password
      };
      break;
    }
    // default: {
    //   console.log('There is no default case!!');
    //   break;
    // }
  }
  return state;
};

export default loginReducer;
