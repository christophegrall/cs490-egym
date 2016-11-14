export class AuthResponse {
    public token: string;

    constructor(customToken: string) {
        this.token = customToken;
    }
}
