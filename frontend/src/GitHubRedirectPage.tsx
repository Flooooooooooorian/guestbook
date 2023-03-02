import {useSearchParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";

export default function GitHubRedirectPage() {

    const [searchParam] = useSearchParams();
    const code: string | null = searchParam.get("code");
    const client_id = "68f4dcabd39a63affbb1";
    const client_secret = "87b9b7a40b1ab0ddb597f5defdddc733bb1b74e8";
    const [token, setToken] = useState<string>("");

    useEffect(() => {
        axios.post("/api/users/" + code)
            .then((response) => {
                axios.get("https://api.github.com/user", {
                    headers: {
                        "Authorization": "Bearer " + response.headers.getAuthorization
                    }
                })
                    .then((r) => {
                        console.log(r);
                    })
                    .catch((e) => {
                        console.log(e)
                    })
            })
            .catch((error) => {
                console.error(error);
            });
    }, []);

    return (
        <div>
            <p>Welcome back {code}</p>
        </div>
    );
}