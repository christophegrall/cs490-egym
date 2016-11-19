export class AuthResponse {
    public token: string;
    public statusCode: number;
    public body: string;

    constructor(status: number, body: string, customToken?: string) {
        this.statusCode = status;
        this.body = body;
        if(customToken) {
            this.token = customToken;
        }
    }
}

export class Auth {
    public username: string;
    public password: string;

    constructor(
        username: string,
        password: string
    ) {
        this.username = username;
        this.password = password;
    }
}
