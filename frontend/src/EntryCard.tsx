import {GuestbookEntry} from "./GuestbookEntry";

type EntryCardProps = {
    entry: GuestbookEntry,
}

export default function EntryCard(props: EntryCardProps){

    const date = props.entry.dateTime;

    return(
        <div>
            <h2>{props.entry.title}</h2>
            <div>
                <h4>written by {props.entry.author}</h4>
                <>{date}</>
            </div>
            <p>{props.entry.content}</p>
        </div>
    );
}