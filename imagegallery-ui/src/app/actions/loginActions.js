export function login(username, password) {
  return {
    type: 'LOGIN',
    payload: new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve({ username, password });
      }, 2000);
    })
    // payload : {
    //     username: username,
    //     password: password
    // }
  };
}
