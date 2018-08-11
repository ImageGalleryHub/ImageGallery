export function login(username, password) {
  return {
    type: 'LOGIN',
    payload: new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve({ username, password });
        console.log(username + ' ' + password);
      }, 2000);
    })
  };
}
